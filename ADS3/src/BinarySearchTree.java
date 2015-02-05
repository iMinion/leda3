import java.util.Scanner;

public class BinarySearchTree {
	private Node root = null;
	private StringBuilder sb = new StringBuilder();
	private int max;
	private int count;
	public void insert(int data) {
		if(root == null) {
			root = new Node(data);
			max = data;
		}
		else {
			if(data > max) max = data;
			insert(root, new Node(data));
		}
	}
	
	public void insert(Node root, Node data) {
		if(root == null) {
			root = data;
		}
		else if(root.getData() > data.getData()) {
			if(root.getLeft() == null) {
				root.setLeft(data); 
			}
			else insert(root.getLeft(), data);
		}
		else {
			if(root.getRight() == null) {
				root.setRight(data);
			}
			else insert(root.getRight(), data);
		}
	}
	
	public String inOrder() {
		sb = new StringBuilder();
		inOrder(root);
		if(sb.length() > 0) return sb.toString().substring(0, sb.length() -1);
		else return sb.toString();
	}
	
	public void inOrder(Node root) {
		if(root != null) {
			inOrder(root.getLeft());
			sb.append(Integer.toString(root.getData()));
			sb.append(",");
			inOrder(root.getRight());
		}
	}
	
	public String postOrder() {
		sb = new StringBuilder();
		postOrder(root);
		if(sb.length() > 0) return sb.toString().substring(0, sb.length() -1);
		else return sb.toString();
	}
	
	public void postOrder(Node root) {
		if(root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			sb.append(Integer.toString(root.getData()));
			sb.append(",");
		}
	}
	
	public void removeNode(int data) {
		removeNode(root, data, null);
	}
	
	public  void removeNode(Node node,int data,Node prev){	
		if(node.getData() == data){
			if(node.getLeft() == null && node.getRight() ==null){
				if(prev.getData()>node.getData()){
					prev.setLeft(null);
				}else prev.setRight(null);
			}else if(node.getRight() == null){
				if(prev.getData() > node.getData()){
					prev.setLeft(node.getLeft());
				}else prev.setRight(node.getLeft());
			}else if(node.getLeft() == null){
				if(prev.getData()>node.getData()){
					prev.setLeft(node.getRight());
				}else prev.setRight(node.getRight());
			}else{
				Node temp=node.getLeft();
				Node tmpPrev=null;
				while(temp.getRight() != null){
					tmpPrev=temp;
					temp=temp.getRight();
				}
				node.setData(temp.getData());
				tmpPrev.setRight(null);
			}
		}else if(node.getData() > data){
			prev=node;
			removeNode(node.getLeft(),data,prev);
		}else{
			prev=node;
			removeNode(node.getRight(),data,prev);
		}
	}

	public String search(int data) {
		sb = new StringBuilder();
		count = 0;
		Node temp =new Node(data);
		sb.append(search(root, temp, null));
		sb.append(",");
		sb.append(count);
		return sb.toString();
	}
	
	public boolean search(Node root, Node node, Node prev) {
		if(root == null || node == null) {
			if(prev == null) count = 0;
			else count = prev.getData();
			return false;
		}
		else {
			count++;
			if(root.getData() > node.getData()) {
				if(root.getLeft() != null) {
					if(root.getLeft().getData() > node.getData())  { prev = root.getLeft(); } 
				}
				return search(root.getLeft(), node, prev);
			}
			else if(root.getData() < node.getData()) {
				if(root.getRight() != null) {
					if(root.getRight().getData() > node.getData()) { prev = root.getRight(); }
				}
				return search(root.getRight(), node, prev);
			}
			else {
				return true;
			}
		}
	}
	
	public String toString() {
		return sb.toString();
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(",");
		for(int i = 0; i < str.length; ++i) {
			if(str[i].charAt(0) == 'I') {
				bst.insert(Integer.parseInt(str[i].substring(1))); 
				System.out.println(bst.inOrder());
			}
			else if(str[i].charAt(0) == 'R') {
				bst.removeNode(Integer.parseInt(str[i].substring(1)));
				System.out.println(bst.postOrder());
			}
			else {
				System.out.println(bst.search(Integer.parseInt(str[i].substring(1))));
			}
		}
		sc.close();
	}
}
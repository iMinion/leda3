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
			sb.append(" ");
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
			sb.append(" ");
		}
	}
	
	public String search(int data) {
		sb = new StringBuilder();
		count = 0;
		sb.append(search(root, new Node(data), null));
		sb.append(", ");
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
				return search(root.getLeft(), node, root);
			}
			else if(root.getData() < node.getData()) {
				return search(root.getRight(), node, root);
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
		String str[] = sc.nextLine().split(", ");
		for(int i = 0; i < str.length; ++i) {
			bst.insert(Integer.parseInt(str[i]));
			System.out.println(bst.inOrder());
		}
		System.out.println(bst.search(2));
		sc.close();
	}
}
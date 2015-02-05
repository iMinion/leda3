public class BinarySearchTree {
	private Node root = null;
	private Node node; 
	private StringBuilder sb = new StringBuilder();
	public void insert(int data) {
		if(root == null) {
			root = new Node(data);
			node = root;
		}
		else insert(node, new Node(data));
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
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void inOrder(Node root) {
		if(root != null) {
			inOrder(root.getLeft());
			System.out.println(root.getData());
			inOrder(root.getRight());
		}
	}
	
	public String toString() {
		return sb.toString();
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		for(int i = 0; i < 10; ++i) {
			bst.insert(i);
		}
		bst.inOrder();
		System.out.println(bst);
	}
}
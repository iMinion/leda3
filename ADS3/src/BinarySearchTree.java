public class BinarySearchTree {
	private Node root = new Node();
	
	public void insert(int data) {
		insert(root, data);
	}
	
	public void insert(Node node, int data) {
		if(node == null) {
			node = new Node(data);
		}
		else if(node.getData() > data) {
			insert(node.getLeft(), data);
		}
		else {
			insert(node.getRight(), data);
		}
	}
	public static void main(String[] args) {
		
	}
}
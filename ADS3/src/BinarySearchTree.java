import java.util.Stack;

public class BinarySearchTree {
	private Node root;
	private StringBuilder sb = new StringBuilder();
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
	
	Stack<Node> myStack = new Stack<Node>();
	public void inOrder() {
		inOrder(root);
	}
	
	public void inOrder(Node root) {
		myStack.push(root);
		if(root == null) {
			if(myStack.size() == 1) {
				myStack.pop();
				return;
			}
			else {
				sb.append(myStack.pop());
				inOrder(myStack.peek().getRight());
			}
		}
		else {
			inOrder(root.getLeft());
		}
	}
	
	public String toString() {
		
		return null;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		for(int i = 0; i < 10; ++i) {
			bst.insert(i);
		}
	}
}
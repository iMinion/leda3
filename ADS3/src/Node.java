
public class Node {
	private int data;
	private Node left = null;
	private Node right = null;
	
	public Node() {
		data = 0;
		left = null;
		right = null;
	}
	
	public Node(int data) {
		this.data = data;
	}
	
	public void setLeft(Node l) {
		left = l;
	}
	
	public void setRight(Node r) {
		right = r;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public String toString() {
		return Integer.toString(this.data);
	}
	
}

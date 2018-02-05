
public class Node {

	Node left;
	Node right;
	int data;
	
	public static Node insert(int data){
		Node newNode = new Node();
		newNode.data = data;
		newNode.left = null;
		newNode.right= null;
		return newNode;
	}
	
}

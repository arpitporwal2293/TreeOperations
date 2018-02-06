
public class TreeOperations {
	
	public static void main(String[] args) {
		
		//BinaryTree
		Node root = Node.insert(3);
		root.left = Node.insert(5);
		root.right = Node.insert(7);
		root.left.left = Node.insert(8);
		root.left.right = Node.insert(9);
		root.right.left = Node.insert(12);
		root.right.right = Node.insert(15);
		root.left.left.left = Node.insert(16);
		root.left.left.right = Node.insert(18);
		root.left.right.left = Node.insert(19);
		root.left.right.right = Node.insert(20);
		Traversals.inorderTraversal(root);
		System.out.println();
		Traversals.preOrderTraversal(root);
		System.out.println();
		Traversals.postOrderTraversal(root);
		System.out.println();
		Traversals.levelOrderTraversal(root);
		System.out.println();
		int[] arr = new int[100];
		RootToLeafPathAndSum.rootToLeafPath(root, arr, 0);
		System.out.println();
		Node newNode = new Node();
		newNode.data = 8;
		PrintNodesAtKDistanceFromTarget.printNodesAtKDistance(root, newNode, 1);
	}
	
}

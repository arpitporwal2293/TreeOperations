
public class BSTOperations {
	
	public static void main(String[] args) {
			//BinarySearchTree
			BSTNode bstNode = BSTNode.insert(null, 7);
			bstNode = BSTNode.insert(bstNode, 8);
			bstNode = BSTNode.insert(bstNode, 3);
			bstNode = BSTNode.insert(bstNode, 6);
			bstNode = BSTNode.insert(bstNode, 5);
			bstNode = BSTNode.insert(bstNode, 9);
			bstNode = BSTNode.insert(bstNode, 10);
			BSTTraversals.inorderTraversal(bstNode);
			System.out.println();
			BSTTraversals.preOrderTraversal(bstNode);
			System.out.println();
			BSTTraversals.postOrderTraversal(bstNode);
			System.out.println();
			BSTTraversals.levelOrderTraversal(bstNode);
			System.out.println();
			CountAndPrintNodesInRange.printInGivenRange(bstNode, 7, 10);
			System.out.println();
			int count = CountAndPrintNodesInRange.countNodesInRange(bstNode, 7, 10);
			System.out.println(count);
			int[] arr = new int[100];
			BSTRootToLeafPathAndSum.rootToLeafPath(bstNode, arr, 0);
			System.out.println();
			BSTNode newNode = new BSTNode();
			newNode.data = 8;
			BSTPrintNodesAtKDistanceFromTarget.printNodesAtKDistance(bstNode, newNode, 1);
	}

}

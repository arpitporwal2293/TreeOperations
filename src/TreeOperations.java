
public class TreeOperations {

	public static void postOrderTraversal(Node root){
		if(root==null){
			return;
		}else{
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data);
		}
	}
	
	public static void preOrderTraversal(Node root){
		if(root==null){
			return;
		}else{
			System.out.print(root.data);
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
		}
	}
	
	public static void inorderTraversal(Node root){
		if(root==null){
			return;
		}else{
			inorderTraversal(root.left);
			System.out.print(root.data);
			inorderTraversal(root.right);
		}
	}
	
	public static int max(int i,int j){
		return i>j?i:j;
	}
	
	public static int findHeight(Node root){
		if(root==null)
			return 0;
		else return max(findHeight(root.left),findHeight(root.right))+1;
	}
	
	public static void levelOrderTraversal(Node root){
		int h = findHeight(root);
		for(int i=0;i<=h;i++){
			levelOrder(root,i);
		}
	}
	
	public static void levelOrder(Node root,int level){
		if(root==null)
			return;
		if(level==1){
			System.out.print(root.data);
		}else{
			levelOrder(root.left, level-1);
			levelOrder(root.right, level-1);
		}
	}
	
	public static void printPath(int[] path,int pathLen){
		for(int i=0;i<pathLen;i++){
			System.out.print(path[i]);
		}
		System.out.println();
	}
	
	public static void printPathSum(int[] path,int pathLen){
		int sum=0;
		for(int i=0;i<pathLen;i++){
			sum+=path[i];
		}
		System.out.println(sum);
	}
	
	public static void rootToLeafPath(Node root,int[] path,int pathLen){
		if(root==null){
			return;
		}
		path[pathLen] = root.data;
		pathLen++;
		if(root.left==null && root.right==null){
			printPath(path, pathLen);
			printPathSum(path, pathLen);
		}else{
			rootToLeafPath(root.left, path, pathLen);
			rootToLeafPath(root.right, path, pathLen);
		}
	}
	
	
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
		inorderTraversal(root);
		System.out.println();
		preOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);
		System.out.println();
		levelOrderTraversal(root);
		System.out.println();
		int[] arr = new int[100];
		rootToLeafPath(root, arr, 0);
	}
	
}

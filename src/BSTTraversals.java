
public class BSTTraversals {
	
	public static void postOrderTraversal(BSTNode root){
		if(root==null){
			return;
		}else{
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data);
		}
	}
	
	public static void preOrderTraversal(BSTNode root){
		if(root==null){
			return;
		}else{
			System.out.print(root.data);
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
		}
	}
	
	public static void inorderTraversal(BSTNode root){
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
	
	public static int findHeight(BSTNode root){
		if(root==null)
			return 0;
		else return max(findHeight(root.left),findHeight(root.right))+1;
	}
	
	public static void levelOrderTraversal(BSTNode root){
		int h = findHeight(root);
		for(int i=0;i<=h;i++){
			levelOrder(root,i);
		}
	}
	
	public static void levelOrder(BSTNode root,int level){
		if(root==null)
			return;
		if(level==1){
			System.out.print(root.data);
		}else{
			levelOrder(root.left, level-1);
			levelOrder(root.right, level-1);
		}
	}
	
}

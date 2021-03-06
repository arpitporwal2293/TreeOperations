
public class Traversals {

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

	public static void reverselevelOrder(Node root,int level){
		if(root==null)
			return;
		if(level==1){
			System.out.print(root.data);
		}else{
			reverselevelOrder(root.right, level-1);
			reverselevelOrder(root.left, level-1);
		}
	}

	public static void reverseLevelOrderTraversal(Node root){
		int h = findHeight(root);
		for(int i=h;i>=0;i--){
			reverselevelOrder(root,i);
		}
	}

	public static void spiralLevelOrderTraversal(Node root){
		int h = findHeight(root);
		int order = 0;
		for(int i=0;i<=h;i++){
			spiralLevelOrder(root,i,order);
			order++;
		}
	}

	public static void spiralLevelOrder(Node root,int level,int order){
		if(root==null)
			return;
		if(level==1){
			System.out.print(root.data);
		}else{
			if(order%2==0){
				spiralLevelOrder(root.left, level-1,order);
				spiralLevelOrder(root.right, level-1,order);
			}else{
				spiralLevelOrder(root.right, level-1,order);
				spiralLevelOrder(root.left, level-1,order);
			}
		}
	}

}

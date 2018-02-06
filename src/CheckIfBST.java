
public class CheckIfBST {

	public static boolean checkIfBST(BSTNode root){
		if(root==null)
			return true;
		if(root.left!=null && root.left.data>root.data)
			return false;
		if(root.right!=null && root.right.data<root.data)
			return false;
		if(!checkIfBST(root.left) && !checkIfBST(root.right))
			return false;
		
		return true;
	}
	
}

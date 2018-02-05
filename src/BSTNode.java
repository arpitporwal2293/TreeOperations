
public class BSTNode {

	BSTNode left;
	BSTNode right;
	int data;
	
	public static BSTNode insert(BSTNode root,int data){
		BSTNode newNode = new BSTNode();
		newNode.data = data;
		if(root==null){
			return newNode;
		}else if(data<=root.data){
			root.left = insert(root.left, data);
		}else{
			root.right = insert(root.right, data);	
		}
		return root;
	}
	
}

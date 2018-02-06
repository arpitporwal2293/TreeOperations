
public class CountAndPrintNodesInRange {

	public static int countNodesInRange(BSTNode root,int low,int high){
		if(root==null)
			return 0;
		if(root.data>=low && root.data<=high)
			return 1 + countNodesInRange(root.left, low, high) + countNodesInRange(root.right, low, high); 
		else if(root.data<low){
			return countNodesInRange(root.right, low, high);
		}else
			return countNodesInRange(root.right, low, high);
	}
	
	public static void printInGivenRange(BSTNode root,int low,int high){
		if(root==null)
			return;
		else if(root.data<low)
			printInGivenRange(root.right, low, high);
		else if(root.data>high)
			printInGivenRange(root.left, low, high);
		else{
			if(root.data>=low && root.data<=high){
				System.out.print(root.data);
			}
			printInGivenRange(root.left, low, high);
			printInGivenRange(root.right, low, high);
		}
	}
	
}


public class BSTPrintNodesAtKDistanceFromTarget {

	//function to print nodes at K distance from root
			public static void printKNodesDown(BSTNode root,int k){
				if(root ==null || k<0)
					return;
				if(k==0)
					System.out.print(root.data);
				else{
					printKNodesDown(root.left, k-1);
					printKNodesDown(root.right, k-1);
				}
			}
			
			public static int printNodesAtKDistance(BSTNode root,BSTNode target,int k){
				if(root==null)
					return -1;
				if(root.data==target.data){
					printKNodesDown(root, k);
					return 0;
				}
				//dl is distance between roots left child and target node
				int dl = printNodesAtKDistance(root.left, target, k);
				//if target found in left subtree
				if(dl!=-1){
					//check if distance +1 -> root to target distance is k then print root data
					//else go to right child of root and reduce the distance by k-dl-2 as distance between
					//roots left child and right child is 2
					if(dl+1==k)
						System.out.print(root.data);
					else
						printKNodesDown(root.right, k-dl-2);
					
					return dl+1;
				}
				
				//same as above for right subtree
				int dr = printNodesAtKDistance(root.right, target, k);
				if(dr!=-1){
					if(dr+1==k)
						System.out.print(root.data);
					else
						printKNodesDown(root.left, k-dr-2);
					
					return dr+1;
				}
				
				return -1;
			}
	
}


public class BSTOperations {
	
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
	
	public static void rootToLeafPath(BSTNode root,int[] path,int pathLen){
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
	
	public static void main(String[] args) {
			//BinarySearchTree
			BSTNode bstNode = BSTNode.insert(null, 7);
			bstNode = BSTNode.insert(bstNode, 8);
			bstNode = BSTNode.insert(bstNode, 3);
			bstNode = BSTNode.insert(bstNode, 6);
			bstNode = BSTNode.insert(bstNode, 5);
			bstNode = BSTNode.insert(bstNode, 9);
			bstNode = BSTNode.insert(bstNode, 10);
			inorderTraversal(bstNode);
			System.out.println();
			preOrderTraversal(bstNode);
			System.out.println();
			postOrderTraversal(bstNode);
			System.out.println();
			levelOrderTraversal(bstNode);
			System.out.println();
			printInGivenRange(bstNode, 7, 10);
			System.out.println();
			int count = countNodesInRange(bstNode, 7, 10);
			System.out.println(count);
			int[] arr = new int[100];
			rootToLeafPath(bstNode, arr, 0);
			System.out.println();
			BSTNode newNode = new BSTNode();
			newNode.data = 8;
			printNodesAtKDistance(bstNode, newNode, 1);
	}

}

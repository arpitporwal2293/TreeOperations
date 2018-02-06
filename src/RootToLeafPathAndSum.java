
public class RootToLeafPathAndSum {

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
	
}

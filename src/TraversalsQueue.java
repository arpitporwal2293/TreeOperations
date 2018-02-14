import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraversalsQueue {

	public static void levelOrder(Node root){
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node node = q.remove();
			System.out.print(node.data);
			if(node.left!=null){
				q.add(node.left);
			}
			if(node.right!=null){
				q.add(node.right);
			}
		}
	}
	
	public static void reverseLevelOrder(Node root){
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		q.add(root);
		while(!q.isEmpty()){
			Node node = q.remove();
			s.add(node);
			if(node.left!=null){
				q.add(node.left);
			}
			if(node.right!=null){
				q.add(node.right);
			}
		}
		
		while(!s.isEmpty()){
			System.out.print(s.pop().data);
		}
	}
	
}

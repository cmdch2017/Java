package test927;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
class Node{
	int val;
	Node left;
	Node right;
}
enum Week{
	Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;
}
enum Gender{
    Female,Male;
}
public class EnumDemo{
	public static List<List<Integer>> levelOrder(Node root) {
		if(root==null) return null;
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node a=queue.poll();
			if(a.left!=null) { 
				queue.add(a.left);
			}
			if(a.right!=null) {
				queue.add(a.right);
			}
		}
		List<List<Integer>> list=new LinkedList<>();
		List <Integer> a=new LinkedList<>();
		list.add(a);
		return null;
	}
	public  boolean isSameTree(Node p,Node q) {
		if(p==null&&q==null) return true;
		if(p==null&&q!=null) return false;
		if(p!=null&&q==null) return false;
		return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)&&(p.val==q.val);
	}
	public static void postorder(Node root) {
		Stack<Node> stack=new Stack<>();
		Node last=null;
		while(!stack.isEmpty()||root!=null) {
				while(root!=null) {
					stack.push(root);
					root=root.left;
					}
				Node temp=stack.peek();
				if(temp.right==null||last==temp.right) {
				stack.pop();
				last=temp;
				}
				else {
				root=temp.right;
				}				
		}
	}
    public static void main(String[] args){
    	System.out.println(Arrays.toString(Week.values()));
    	System.out.println(Week.class);
        Gender gender=Gender.Female;
        System.out.println(Arrays.toString(Gender.values()));
        Gender g=Gender.valueOf("Female");
    }
}
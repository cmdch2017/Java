package test_925;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
	int val;
	Node left;
	Node right;
}
public class Solution {
	Node root=null;
	public void layerorder(Node root) {
		if(root==null) return ;
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node a=queue.poll();
			System.out.println(a.val);
			if(a.left!=null)
			queue.add(a.left);
			if(a.right!=null) {
				queue.add(a.right);
			}
		}
	}
	public static void quickSort() {
		
	}
	public void inorder(Node root) {
		//入左出右
		Stack<Node> stack=new Stack<Node>();
		while(stack!=null||root!=null) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			Node temp=stack.pop();
			root=temp.right;
		}
	}
	public void postorder(Node root) {
		if(root==null) return;
		postorder(root.left);
		postorder(root.right);
	}
	public void postOrder(Node root) {
		Node last=null;
		Stack<Node> stack=new Stack<Node>();
		while(!stack.isEmpty()||root!=null) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			//显然第二次遍历到结点的时候不要先pop();
		    //先取出元素temp，有两种可能，第一种有rightchild，第二种没有rightchild回溯
			Node temp=stack.peek();
			//回溯的两种情况，一种右孩子为空，还有一种右子树回溯的时候会遇到temp.right!=null,但是需要输出的情况
			//O
			//  O
			//    O
			//上图这棵树，中间这个结点就属于第三遍遍历的时候temp.right!=null，但是需要输出的情况
			if(temp.right==null||temp.right==last) {
			stack.pop();
			last=temp;
			}
			else {
			root=temp.right;
			}
			}
	}
}

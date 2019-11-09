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
		//�������
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
			//��Ȼ�ڶ��α���������ʱ��Ҫ��pop();
		    //��ȡ��Ԫ��temp�������ֿ��ܣ���һ����rightchild���ڶ���û��rightchild����
			Node temp=stack.peek();
			//���ݵ����������һ���Һ���Ϊ�գ�����һ�����������ݵ�ʱ�������temp.right!=null,������Ҫ��������
			//O
			//  O
			//    O
			//��ͼ��������м�����������ڵ����������ʱ��temp.right!=null��������Ҫ��������
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

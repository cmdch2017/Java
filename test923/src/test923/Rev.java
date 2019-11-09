package test923;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val=val;
	}
}
public class Rev {
	public void preorder(TreeNode root) {
		if(root==null) return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	public void postorder(TreeNode root) {
		if(root==null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.val);
	}
	public void inorder2(TreeNode root) {
		Stack<TreeNode> stack=new Stack<>();
		TreeNode cur= root;
		while(!stack.isEmpty()||cur!=null) {
			while(cur!=null) {
				stack.push(cur);
				cur=cur.left;
			}
			TreeNode temp=stack.pop();
			System.out.println(temp.val);
			cur=temp.right;
		}
	}
	public void preorder2(TreeNode root) {
		//入左出右
		Stack<TreeNode> stack=new Stack<>();
		TreeNode cur=root;
		while(!stack.isEmpty()||cur!=null) {
			while(cur!=null) {
				//入
				stack.push(cur);
				System.out.println(cur.val);
				//左
				cur=cur.left;
			}
			//出
			TreeNode top=stack.pop();
			//右
			cur=top.right;
		}
	}
	private static void heapify(int[] array, int size, int index) {
		if(size==0) return ;
	while(true) {	
		int leftchild=index*2+1;
		int rightchild=index*2+2;
		if(leftchild>=size) return;
		int max=leftchild;
		if(rightchild<size) {
			if(array[leftchild]<array[rightchild]) {
				max=rightchild;
			}
		}
		//如果有必要交换，就交换
		if(array[max]>array[index]) {
			swap(array,max,index);
			index=max;
		}
	}
	}
	private static void swap(int[] array, int max, int index) {
		// TODO 自动生成的方法存根
		int temp;
		temp=array[max];
		array[max]=array[index];
		array[index]=temp;
	}
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode root=n1;
		n1.left=n2;
		n2.right=n3;
		Rev s=new Rev();
		//s.inorder(root);
		//s.preorder(root);
		//s.postorder(root);
		s.preorder(root);
		s.inorder2(root);
	}
}

package test_825;
class Node{
	int val;
	Node left;
	Node right;
	Node(int val){
		this.val=val;
	}
}
public class Solution {
	static int depth=0;
	void preTreeDepth(Node root,int h){
	   if(root==null) return;
	   if(h>depth)
	   depth=h;
	   preTreeDepth(root.left,h+1);
	   preTreeDepth(root.right,h+1);
	   }
	public static Node buildTree() {
		Node a=new Node(1);
		Node b=new Node(2);
		Node c=new Node(3);
		Node d=new Node(3);
		a.left=b;
		a.right=c;
		c.left=d;
		return a;
	}
	public static void main(String[] args) {
		Solution tree=new Solution();
		Node root=buildTree();
		tree.preTreeDepth(root,1);
		System.out.println(depth);
	}
}

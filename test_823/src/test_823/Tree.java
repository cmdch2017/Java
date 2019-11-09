package test_823;

import java.awt.List;
import java.util.*;
class Node{
	String val;
	Node left=null;
	Node right=null;
	Node(String string){
		this.val=string;
	}
	@Override
	public String toString() {
		//return String.format("%c的左边是%c右边是%c",val,left.val,right.val);
		return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
}

public class Tree {
Node node=null;
static int count=0;
public static Node buildTree() {
	Node a=new Node ("A");
	Node b=new Node ("B");
	Node c=new Node ("C");
	Node d=new Node ("D");
	Node e=new Node ("E");
	Node f=new Node ("F");
	Node g=new Node ("G");
	Node h=new Node ("H");
	a.left=b;
	a.right=c;
	b.left=d;
	b.right=e;
	c.right=f;
	e.left=g;
	f.right=h;
	return a;	
}
public static void preOrderTraversal(Node root) {
	if(root==null) {
		return;
	}
	System.out.println(root.val);
	// if(root.left==null&&root.right==null)
	//count++;
	preOrderTraversal(root.left);
	preOrderTraversal(root.right);
}
public static void inOrderTraversal(Node root) {
	if(root==null) {
		return;
	}
	inOrderTraversal(root.left);
	System.out.println(root.val);
	inOrderTraversal(root.right);
}
public static void postOrderTraversal(Node root) {
	if(root==null) {
		return;
	}
	postOrderTraversal(root.left);
	postOrderTraversal(root.right);
	System.out.println(root.val);
} 
public  int test2(int n) {
	//加了10次1
	if (n == 1) {
		return 1;
	}
	//问题在于递归前每次都初始化了sum=0;
	int sum = 0;
	test2(n - 1);
	sum += n;
	return sum;
}
int sum = 0;
public  int test(int n) {
	sum += n;
	if (n == 1) {
		return 1;
	}
	test(n - 1);
	return sum;
}
public  int test3(int n) {
	if (n == 1) {
		return 1;
	}
	else {
		return n+test3(n-1);
	}
}

public static void main(String[] args) {
	Tree l=new Tree();
	Node tree=buildTree();
	//preOrderTraversal(tree);
	//System.out.println(count);
    //inOrderTraversal(tree);
	postOrderTraversal(tree);
	System.out.println(tree.toString());
}
}

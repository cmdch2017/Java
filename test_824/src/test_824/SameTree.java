package test_824;


import java.util.List;
import java.util.Stack;

import java.util.ArrayList;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class SameTree {
public static TreeNode buildTree() {
		TreeNode a=new TreeNode ('A');
		TreeNode b=new TreeNode ('B');
		TreeNode c=new TreeNode ('C');
		TreeNode d=new TreeNode ('D');
		TreeNode e=new TreeNode ('E');
		TreeNode f=new TreeNode ('F');
		TreeNode g=new TreeNode ('G');
		TreeNode h=new TreeNode ('H');
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		c.right=f;
		e.left=g;
		f.right=h;
		return a;	
	}
public boolean isSameTree(TreeNode p,TreeNode q) {
if(p==null&&q==null) return true;
if(p==null||q==null) return false;
return (p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
}
boolean search(TreeNode root,TreeNode t) {
	//子树问题，首先找到子树t的头结点使得（root.val==t.val）
	//判断是否包含有树的部分
	if(root==null) return false;
	if(root.val==t.val) {
		if(isSameTree(root,t))
			return true;
	}
	if(search(root.left,t))return true;
	return search(root.right,t);
}
private boolean match(char left,char right) {
	return ((left=='(' && right==')')||(left=='{' && right=='}')||(left=='[' && right==']'));
}
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        switch (ch) {
            case '(': case '[': case '{':
                stack.push(ch);break;
            case ')': case ']': case '}': {
                if (stack.empty()) {
                    return false;
                }
                char left=stack.pop();
                if (!match(left, ch)) { return false; }break;
            }
        }
    }
//结束for循环，遍历结束，栈不为空说明错误
    if (!stack.empty()) {
        return false;
    }
    return true;
}
static TreeNode buildTree(List<Character> preorder,List <Character> inorder) {
	if(preorder.size()==0) {
		return null;
	}
	//找到头结点
	char rootValue=preorder.get(0);//找到前序遍历的头结点在中序的位置是leftCount
	int leftCount=inorder.indexOf(rootValue);
	TreeNode root=new TreeNode(rootValue);
	List<Character> leftPreorder=preorder.subList(1, 1+leftCount);
	List<Character> leftInorder=inorder.subList(0, leftCount);
	TreeNode left=buildTree(leftPreorder,leftInorder);
	List<Character> rightPreorder=preorder.subList(1+leftCount,preorder.size());
	List<Character> rightInorder=inorder.subList(leftCount+1, inorder.size());
	TreeNode right=buildTree(rightPreorder,rightInorder);
	root.left=left;root.right=right;
	return root;
}
static TreeNode buildTree2(List<Character> lastorder,List <Character> inorder) {
	if(lastorder.size()==0) {
		return null;
	}
	char rootValue=lastorder.get(0);
	int leftcount=inorder.indexOf(rootValue);
	//int rightCount=preorder.size()-leftCount-1;
	TreeNode root=new TreeNode(rootValue);
	List<Character> leftlastorder=lastorder.subList(0, lastorder.indexOf(root));
	List<Character> leftinorder=inorder.subList( inorder.indexOf(root),inorder.size());
	List<Character> rightlastorder=lastorder.subList(0, lastorder.indexOf(root));
	List<Character> rightinorder=inorder.subList(0, inorder.indexOf(root));
	return null;
}
public boolean isMirror(TreeNode p,TreeNode q) {
	if(p==null&&q==null) return true;
	if(p==null||q==null) return false;
	return (p.val==q.val&&isMirror(p.left,q.right)&&isMirror(p.right,q.left));
}

public static void main(String[] args) {
	String s="{}{}{}{[]}";
	SameTree l=new SameTree();
	System.out.println(l.isValid(s));
	System.out.println(l.isValid(s));
	System.out.println(l.isValid(s));
	TreeNode tree=buildTree();
}
}

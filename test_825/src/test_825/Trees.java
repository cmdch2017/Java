package test_825;
import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val=val;
	}

}
public class Trees {
	//还原二叉树
public static TreeNode buildTree(List <Integer> inorder,List <Integer> postorder) {
	if(inorder.size()==0) return null;
	int rootValue=postorder.get(postorder.size()-1);
	int leftCount=inorder.indexOf(rootValue);
	
	List<Integer> leftInorder=inorder.subList(0, leftCount); 
	List<Integer> leftPostorder=inorder.subList(0, leftCount); //Arrays.copyofRange
	TreeNode left=buildTree(leftInorder,leftPostorder);
	List<Integer> rightInorder=inorder.subList(leftCount+1,inorder.size());
	List<Integer> rightPostorder=inorder.subList(leftCount,postorder.size());
	TreeNode right=buildTree(rightInorder,rightPostorder);
	//获取头结点
	TreeNode root=new TreeNode(rootValue);
	//链接
	root.left=left;
	root.right=right;
	return root;
}
public static class ReturnValue{
	TreeNode root;
	int used;
}
public static ReturnValue buildTreePreorder(List<Integer> preorder) {
//终止条件1 先序为空或者遍历结束
if(preorder.size()==0) {
	ReturnValue rv=new ReturnValue();
	rv.root=null;
	rv.used=0;
	return rv;
}
//终止条件2 遇到'#'就返回
int rootValue=preorder.get(0);
if(rootValue=='#') {
	ReturnValue rv=new ReturnValue();
	rv.root=null;
	rv.used=1;
	return rv;
}
//3
ReturnValue leftRV=buildTreePreorder(preorder.subList(1, preorder.size()));
ReturnValue rightRV=buildTreePreorder(preorder.subList(1+leftRV.used, preorder.size()));
//4建立树
TreeNode root=new TreeNode(rootValue);
	root.left=leftRV.root;
	root.right=rightRV.root;
	//这里为了返回两个参数就建立一个对象rv
	ReturnValue rv=new ReturnValue();
	rv.root=root;
	rv.used=1+leftRV.used+rightRV.used;
	return rv;
}
private int height(TreeNode root) {
	if(root==null) return 0;
	   int left=height(root.left);
	   int right=height(root.right);
	   int height=Math.max(left, right);
	   return height+1;
}
private static void preorder(StringBuilder sb,TreeNode root) {
	if(root==null) return;
	sb.append("(");
	//根
	sb.append(root.val);	
	//左
	if(root.left==null&&root.right!=null) {
		sb.append("()");
	}
	else {
		sb.append(root.left);
	}
	//右
	preorder(sb,root.right);
	sb.append(")");
}
public boolean isBalanced(TreeNode root) {
	if(root==null) return true;
	//是否平衡的
	boolean left=isBalanced(root.left);
	if(!left) return false;
	boolean right=isBalanced(root.right);
	if(!right) return false;
	int leftHeight=height(root.left);
	int rightHeight=height(root.right);
	if((leftHeight==rightHeight)||(leftHeight+1==rightHeight)||(leftHeight==rightHeight+1)) {
		return true;
	}
	return false;
}

boolean search(TreeNode root,TreeNode t) {
	if(root==null) return false;
	if(root==t) {
	return true;
	}
	if(search(root.left,t)||search(root.right,t)) return true;
	return false;
}
public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
	if(root==p||root==q) return root;
	boolean pInLeft=search(root.left,p);
	boolean qInLeft=search(root.left,q);
	if(pInLeft&&qInLeft) {
		return lowestCommonAncestor(root.left,p,q);
	}
	if(!pInLeft&&!qInLeft) {
		return lowestCommonAncestor(root.right,p,q);
	}
	return root;
}
public static void levelOrderTraversal(TreeNode root) {
	if(root==null) return ;
	Queue <TreeNode> queue=new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()) {
		TreeNode head=queue.poll();//A
		if(head.left!=null) queue.add(head.left);
		System.out.println(root.val);
		if(head.right!=null) queue.add(head.right);
	}
}
public static TreeNode buildTree() {
	TreeNode a=new TreeNode (1);
	TreeNode b=new TreeNode (2);
	TreeNode c=new TreeNode (3);
	a.left=b;
	a.right=c;
	return a;	
}
public static void main(String[] args) {
	List<Integer> preorder=Arrays.asList(1,2,3,(int)'#',4,5,6,7,8,9,10);
	TreeNode root=buildTree();
	levelOrderTraversal(root);
/*	while(scanner.hasNext()) {
		String line=scanner.nextLine();
		System.out.println("刚才读到的输入"+line);
	}
*/
}
}

package test1025;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node
    { // 节点类
        double data; // 数据域
        Node right; // 右子树
        Node left; // 左子树  
    }
public class TreeSearch {
	 static Node root; // 树根节点
	 public void insert(double d)
	    {    
	        Node p=new Node(); //待插入的节点
	        p.data=d;
	        if(root==null)
	        {
	            root=p;
	        }
	        else
	        {
	            Node parent=new Node();
	            Node current=root;
	            while(true)
	            {
	                parent=current;
	                if(d>current.data)    
	                {
	                    current=current.right; // 右子树
	                    if(current==null)
	                    {
	                        parent.right=p;
	                        return;
	                    }
	                }
	                else //本程序没有做key出现相等情况的处理，暂且假设用户插入的节点值都不同
	                {
	                    current=current.left; // 左子树
	                    if(current==null)
	                    {
	                        parent.left=p;
	                        return;
	                    }
	                }
	            }
	        }
	    }
	 public static int inorderTraversal(Node head,double key) {
		 int index=0;
         Stack<Node> stack=new Stack<Node>();
         if (head!=null) {
            while(head!=null||!stack.empty()) {
                 if(head!=null) {
                     stack.push(head);
                     head=head.left;
                 }else {
                	 index++;
                     head=stack.pop();
                     if(head.data==key)
                    	 return index;
                     head=head.right;
                }
            }
        }
         return -1;
    }
	 public static void main(String[] args)    //unit test
	    {    
		 TreeSearch tree=new TreeSearch();
		 int count=0;
		 int i=20000000;
		 //随机生成一个数
		 double test=Math.random()*100;
		 BigDecimal decimal=new BigDecimal(test);
		 double testNumber=decimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		 while(i>0) {
		 double a=Math.random()*100;
		 BigDecimal decimal2=new BigDecimal(a);
	     double d=decimal2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	     tree.insert(d);
	        i--;count++;
		 }
		    long first=System.nanoTime();
		    int value=inorderTraversal(root,testNumber);
            long last=System.nanoTime();
        System.out.println("TreeSearch"+count+"个数据"+" "+(last-first)+"纳秒 "+"index="+value);
	    }
}

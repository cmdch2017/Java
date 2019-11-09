package test1025;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node
    { // �ڵ���
        double data; // ������
        Node right; // ������
        Node left; // ������  
    }
public class TreeSearch {
	 static Node root; // �����ڵ�
	 public void insert(double d)
	    {    
	        Node p=new Node(); //������Ľڵ�
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
	                    current=current.right; // ������
	                    if(current==null)
	                    {
	                        parent.right=p;
	                        return;
	                    }
	                }
	                else //������û����key�����������Ĵ������Ҽ����û�����Ľڵ�ֵ����ͬ
	                {
	                    current=current.left; // ������
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
		 //�������һ����
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
        System.out.println("TreeSearch"+count+"������"+" "+(last-first)+"���� "+"index="+value);
	    }
}

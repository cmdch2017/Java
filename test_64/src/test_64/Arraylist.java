package test_64;

import java.util.Arrays;
class Node{
 int val;
	public Node next;
	Node(int val){
		this.val=val;
	}
}
 class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val=x;
	}
}
public class Arraylist {
public static Node pushFront(Node head,int val) {
	Node node=new Node(val);
	node.next=head;
	return node;
}
public static Node popBack(Node head) {
	if(head==null) return null;
	Node p=head;
	if(p.next==null) return null;
	else{
		while(p.next.next!=null) {
			p=p.next;//找到末尾结点
		}
		p.next=null;
		}
	return head;
}
public Node Find(Node head,int k) {
	Node p=head;
	int count=1;
	if(head==null)return null;
	while(p.next!=null) {
		count++;
		p=p.next;
	}
	if(count<k) return null;
	int temp=count-k;
	Node key=head;
	for(int i=0;i<temp;i++) {
		key=key.next;
	}
	return key;
}
public static  void display(Node head) {
	for(Node cur=head;cur!=null;cur=cur.next) {
		System.out.printf("%d-->",cur.val);
	}
	System.out.println("null");
}

public Node Findkey(Node head) {
	Node p=head;
	Node q=head;
	if(p==null) return null;
	if(p.next==null) return p;
	while(p.next!=null) {
		p=p.next;
		q=q.next;
	if(p.next!=null)
     	p=p.next;
	}
	return q;
}
public Node sear(Node l1,Node l2) {
	Node p=l1;
	Node q=l2;
	int count=0;
	while(p!=null) {
		p=p.next;
	}
	return p;
}
public Node merge(Node l1,Node l2) {
	Node p=l1;
	Node q=l2;
	Node node =null;
//  Node temp=p;
	if(l1==null) return l2;
	if(l2==null) return l1;
	while(p!=null&&q!=null) {
//		if(p.next==null) {
//		 temp=p;
//	}	
	if(p.val<=q.val) {
		if(node==null)
		node=p;
		else {
//		if(p==temp) {
//			node.next=p;
//		}
			while(node.next!=null) {
			node=node.next;
		}
			node.next=p;
	}
	}
	if(p.val>q.val) {
		if(node==null) {
			node=q;
			}
			else {
				while(node.next!=null) {
					node=node.next;	
			}
				node.next=q;
	}
}
	//if(p==null)
	//插入q
	//if(q==null)
	    //插入p
	}
	return node;
	}
public static void main(String[] args) {
	Node n1=new Node(6);
	Node n2=new Node(5);
	Node n3=new Node(4);
	Node head=n1;
	n1.next=n2;
	n2.next=n3;
	head=popBack(head);
}
}


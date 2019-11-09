package test61;
import java.util.Arrays;
class Node{
	public int value;
	public Node next=null;
	public Node(int value) {
		this.value=value;
	}
}

public class Arraylist {
	public static  void display(Node head) {
		for(Node cur=head;cur!=null;cur=cur.next) {
			System.out.printf("%d-->",cur.value);
		}
		System.out.println("null");
	}
	public static  Node pushFront(Node head,int value) {
		Node node=new Node(value);//申请新结点
		node.next=head;//新节点.next=原第一个结点
		return node;//跟新第一个结点为新结点
	}
	public static Node getLast(Node head) {
		Node cur=head;
		while(cur.next!=null) {
			cur=cur.next;
		}
		return cur;
	}
	public static Node pushBack(Node head,int value) {
		Node node=new Node(value);
		if(head==null) {
			node.next=head;
			return node;
		}
		else {
			Node last=getLast(head);
			last.next=node;
			return head;
		}
		}
	public static Node popFront(Node head) {
		if(head==null) {
			return null;
		}
		head=head.next;
		return head;
	}
	public static Node popBack(Node head) {
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			return null;
		}
		else {
			Node lastLast=getLastLast(head);
			lastLast.next=null;
			return head;
		}
		
	}
	private static Node getLastLast(Node head) {
		Node cur=head;
		while(cur.next.next==null) {
			cur=cur.next;
		}
		return cur;
	}
	/*public ListNode reverseList(ListNode head) {
		ListNode newList=null;
		ListNode cur=head;
		while(cur!=null) {
			ListNode next=cur.next;
			cur.next=newList;
			newList=cur;
			cur=next;
		}
		return newList;
	}*/
	public static void main(String[] args) {
		Node head=null;
		head=pushBack(head,1);
		head=pushBack(head,2);
		head=pushBack(head,3);
		display(head);
		head=pushFront(head,10);
		head=pushFront(head,20);
		head=pushFront(head,30);
		display(head);
	}
}
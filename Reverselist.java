package test_611;

class Node{
	 int val;
	 Node next;
 }

public class Reverselist {
	public Node remove(Node head,int val) {
		if(head==null) {
			return null;
		}
		Node p=head;
		Node q=head.next;
		while(q!=null) {
		if(q.val==val) {
			//p.next=p.next.next;
			//q=q.next;
			p.next=q.next;
		}
		else {
			p=q;
		}
		q=q.next;
		if(head.val==val) {
			head=head.next;
		}
		}
		return head;
	}
	public Node remove2(Node head,int val) {
		Node newlist=null;
		Node p=head;
		if(p.next==null)
			return null;
		Node q=head.next;
		if(p.val==val) {
			return head.next;
		}
		//核心
		if(q.val!=val) {
		p.next=newlist;
		newlist=p;
		}
		else {
			p.next=q.next;
			q=p.next;
		}
		
		return newlist;
	}
	public Node remove3(Node head,int val) {
		Node newlist=null;
		Node cur=head;
		Node newLast=null;
		while(cur!=null) {
			Node next=cur.next;
			if(cur.val!=val) {
				if(newlist==null) {
					cur.next=newlist;
					newlist=cur;
				}
				else {
					newLast.next=cur;
					//Node last=newlist;
//					while(last.next!=null) {
//						last=last.next;
//					}
					//cur.next=null;
				}
				newLast=cur;
			}
			cur=next;
		}
		if(newLast!=null) {
			newLast.next=null;
		}
		return newlist;
		}
 public Node reverseList(Node head) {
		Node newlist=null;//新建一个链表
		Node cur=head;
		//Node q=cur.next;
		while(cur!=null) {
			Node q=cur.next;
			cur.next=newlist;
			newlist=cur;
			cur=q;
		}
		return newlist;
 }
}
package test__614;
class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
}
public class Solution {
Node merge(Node head1,Node head2) {
	if(head1==null) return head2;
	if(head2==null) return head1;
	Node p=head1;
	Node q=head2;
	Node node=null;
	Node last=null;
	while(p!=null&&q!=null) {
	if(p.val<=q.val) {
		if(node==null)
			node=p;
		else {
		last.next=p;	
		}
		last=p;
	}
	else {
		if(node==null)
			node=q;
		else {
		last.next=q;	
		}
		last=q;
	}
	if(p!=null) node.next=p;
	else node.next=q;
}
	return node;
}
//É¾³ýÖØ¸´Öµ
Node deleteDuplicated(Node head) {
	Node pre=null;
	Node newhead=head;
	if(head==null) return null;
	while(head!=null) {
		pre=head;
		//if(head.next==null) return head;
		if(head.val==head.next.val) {
			head=head.next;
			Node next=head.next;
			while(head.next!=null&&head.val!=next.val) {
				head=head.next;
			}
			if(next.next!=null)
			pre.next=next.next;
			else
				pre.next=null;
		}
	}
	return newhead;
}
Node reverselist(Node head) {
	Node pre=null;
	while(head!=null) {
		Node next=head.next;
		head.next=pre;
		pre=head;
		head=next;
	}
	return pre;
}

}

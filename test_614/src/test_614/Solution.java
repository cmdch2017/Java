package test_614;
class Node{
	int val;
	Node random;
	Node next;
	Node(int val){
		this.val=val;
	}
}
public class Solution {
public static Node getMid(Node head) {
	if(head==null) return null;
	Node slow=head;
	Node fast=head;
	while(fast!=null) {
		fast=fast.next;
		if(fast==null) break;
		fast=fast.next;
		slow=slow.next;
	}
	return slow;
}
public static Node reverse(Node head) {
	if(head==null) return null;
	Node pre=null;
	Node next=head.next;
	while(head!=null) {
		next=head.next;
		head.next=pre;
		pre=head;
		head=next;
	}
	return pre;
}
public static boolean chkPalindrome(Node A) {
	Node mid=getMid(A);
	Node h2=reverse(mid);
	while(A!=null&&h2!=null) {
		if (A.val!=h2.val) {
			return false;
		}
		A=A.next;
		h2=h2.next;
	}
	return true;
}
public Node copyRandomList(Node head) {
	Node p=head;
	if(p==null) return null;
	while(p!=null) {
	Node node=new Node(p.val);
	node.next=p.next;
	p.next=node;
	node.next=node.next.next;
	}
	p=head;
	while(p!=null) {
	Node node=p.next;
	node.random.next=p.random.next;
	}
	//∑÷¿Î¡¥±Ì
	
	return head;
}
public static void main(String[] args) {
	Node A=new Node(6);
	Node B=new Node(7);
	Node C=new Node(6);
	A.next=B;
	B.next=C;
	C.next=null;
	if(chkPalindrome(A)) {
		System.out.println("Palindrome");
	}
	else {
		System.out.println("error");
	}
}
}

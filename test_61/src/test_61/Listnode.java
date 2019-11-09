package test_61;

import test_611.Node;

class Node{
	 int value;
	 Node next;
}
public class Listnode {
Node reverseList(Node head) {
	Node newlist=null;
	Node p=head;
	if(p==null)return null;
	while(p!=null) {
		Node q=p.next;
		p.next=newlist;
		newlist=p;
		p=q;
	}
	return newlist;
}
public Node remove(Node head,int value) {
	Node newlist=null;
	Node p=head;
	if(p==null) return null;
	while(p!=null) {
		Node q=p.next;
		if(p.value!=value) {
			//p=newlist.next;
			//newlist=p;
		}
	}
	return null;
}
}

package test923;
class Node{
	int val;
	Node pre=null;
	Node next=null;
	Node(int val){
		this.val=val;
	}
}
public class Test {
	//Node first;
	//Node last;
	static Node head=null;
	public static Node tailinsert(Node e) {
		Node result=head;
		if(head==null) {
			head=e;
		}
	else {
		while(head.next!=null) {
			//Node pre=head;
			head=head.next;
		}
		head.next=e;
		e.pre=head;
		}
		return result;
}
	public static Node headinsert(Node e) { 
		Node result=head;
		if(head!=null) {
		e.next=head;
		head.pre=e;
		result=e;
		}
		return result;
	}

	
}

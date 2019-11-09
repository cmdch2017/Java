package test815;
class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
}
public class review {
public Node reverselist(Node head) {
	Node pre=null;
	Node next;
	while(head!=null) {
		next=head.next;
		head.next=pre;
		pre=head;
		head=next;
	}
	
	return pre;
}
public Node deleteduplication(Node head) {
	if(head==null) return null;
	Node first=new Node(0);
	first.next=head;
	Node pre=first;
	while(head!=null&&head.next!=null) {
		if(head.val==head.next.val) {
			int val=head.val;
			
		}
		else {
			//�ƶ�ָ��
			pre=head;
			head=head.next;
		}
	}
	return first.next;
}
public void display(Node head) {
	for(Node cur=head;cur!=null;cur=cur.next) {
		System.out.println(cur.val);
	}
}
public Node combine(Node head1,Node head2) {
	Node result=null;
	Node cur1=head1;
	Node cur2=head2;
	Node last=null;
	while(cur1!=null&&cur2!=null) {
		if(cur1.val<cur2.val) {
			if(result==null)
				result=cur1;
			else {
				last.next=cur1;
			}
			last=cur1;
			cur1=cur1.next;
		}
		else {
			if(result==null)
				result=cur2;
			else {
				last.next=cur2;
			}
			last=cur2;
			cur2=cur2.next;
		}
	}
	if(cur1==null) {
		last.next=cur2;
	}
	else {
		last.next=cur1;
	}
	return result;
}
public static void main(String args[]) {
	review list=new review();
	Node n1=new Node(1);
	Node n2=new Node(2);
	Node n3=new Node(3);
	Node n5=new Node(5);
	Node n6=new Node(6);
	Node n7=new Node(7);
	n1.next=n2;
	n2.next=n3;
	n5.next=n6;
	n6.next=n7;
	Node head=list.reverselist(n1);
	Node head2=list.reverselist(n5);
	//list.display(head);
	//list.display(head2);
	Node result=list.combine(head,head2);
	list.display(result);
}
}
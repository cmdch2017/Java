package linklist;
public class Linklist {
class Node{
	private int value;
	private Node next;
public Node(int value){
	this.value=value;
	this.next=null;
}
}

private Node head;
public Linklist() {
	this.head=null;
}
public void addFirst(int value) {
	Node node=new Node(value);
	if(this.head==null) {
		this.head=node;
	}
	else {
		node.next=this.head;
		this.head=node;
	}
	}
public void display() {
	Node cur=this.head;
	while(cur!=null) {
		System.out.print(cur.value+" ");
		cur=cur.next;
	}
	System.out.println("");
}

public static Node getLast(Node head) {
	Node cur=head;
	while(cur.next!=null) {
		cur=cur.next;
	}
	return cur;
}
public  Node pushback(Node head,int value) {
	if(head==null) {
		return pushFront(head,value);
	}
	else {
		Node newNode=new Node(value);
		Node last=getLast(head);
		last.next=newNode;
		return head;
	}

}
public  Node pushFront(Node head,int value) {
	Node newNode=new Node(value);
	newNode.next=head;
	return newNode;
}

public static void main(String[] args) {
	Linklist mylist=new Linklist();
	mylist.addFirst(1);
	mylist.display();
	
}
}


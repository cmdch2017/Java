package mylist;
public class Mylist {
	class Node{
		private int data;
		private Node next;
	public Node(int data){
		this.data=data;
		this.next=null;
	}
	}//节点类
	private Node head;
	public Mylist() {
		this.head=null;
	}
	public void addFirst(int data) {
		Node node=new Node(data);
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
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		System.out.println("");
	}
	public void addLast(int data) {
		Node node=new Node(data);
		Node cur =this.head;
		if(cur==null) {
			this.head=null;
		}
		else {
		//1、找尾巴
			while(cur.next!=null) {
				cur=cur.next;
			}
		//退出上面的循环，cur所指向的位置就是尾节点
			cur.next=node;
		}
	}
	public static void main(String[] args) {
		Mylist mylist=new Mylist();
		mylist.addFirst(10);
		mylist.addFirst(20);
		mylist.addFirst(30);
		mylist.addLast(10);
		mylist.addLast(20);
		mylist.addLast(30);
		mylist.display();
	}
}

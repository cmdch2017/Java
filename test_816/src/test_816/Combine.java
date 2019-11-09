package test_816;
class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}
	}
class A{
	//属性
	public int a;
	//静态属性
	public static int b;
	//形参
	public void method(int c) {
	//局部变量
		int d;
	}
}
public class Combine {
public Node deletevalue(Node head,int key) {
	Node cur=head;
	Node pre=null;
	while(cur!=null) {
		if(cur.val!=key) {
		cur=cur.next;
		pre=cur;
		}
		else {
			while(cur!=null&&cur.val==key)
			cur=cur.next;
			if(pre==null)
				pre=cur;
		}
		pre.next=cur;
	}
	return head;
}
public Node combination(Node head1,Node head2) {
	Node result=null;
	Node cur1=head1;
	Node cur2=head2;
	Node last=null;
	if(cur1==null) return head2;
	if(cur2==null) return head1;
	while(cur1!=null&&cur2!=null) {
		if(cur1.val<cur2.val) {
			if(result==null) {
				result=cur1;
			}
			else {
				last.next=cur1;
			}
			last=cur1;
			cur1=cur1.next;
		}
		else {
			if(result==null) {
				result=cur2;
			}
			else {
				last.next=cur2;
			}
			last=cur2;
			cur2=cur2.next;
		}
	}
	if(cur1==null) last.next=cur2;
	else last.next=cur1;
	return result;
}
public void display(Node head) {
	for(Node cur=head;cur!=null;cur=cur.next) {
		//System.out.println(cur.val);
		System.out.println(cur.toString());
	}
}
public static void main(String args[]) {
	Combine L=new Combine();
	Node cur1=new Node(1);
	Node cur2=new Node(2);
	Node cur3=new Node(3);
	Node cur4=new Node(3);
	Node cur5=new Node(3);
	Node cur6=new Node(6);
	Node cur7=new Node(7);
	Node cur8=new Node(8);
	Node cur9=new Node(9);
	cur4.next=cur5;
	cur5.next=cur6;
	cur1.next=cur3;
	cur3.next=cur8;
	cur2.next=cur7;
	cur7.next=cur9;
	Node head1=cur1;
	Node head2=cur2;
	Node head=L.combination(head1, head2);
	//L.display(head);
	Node head3=L.deletevalue(cur4, 6);
	L.display(head3);
}
//构造方法不能被继承，类似于父类的基本属性
}

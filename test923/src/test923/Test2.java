package test923;

public class Test2 {
	class Node{
		int val;
		Node pre;
		Node next;
		Node(int val){
			this.val=val;
		}
		@Override
		public String toString() {
			return "Node [val=" + val + ", pre=" + pre + ", next=" + next + "]";
		}
	}
	private Node first=null;
	private Node last=null;
	public boolean isEmpty(){
	    return first == null;
	 }
    public void addLast(int value){
        Node e=new Node(value);
        if(isEmpty()) {
        	first=e;
        	last=e;
        }
        else {
        	last.next=e;
        	e.pre=last;
        }
        last=e;
    }
    public Node addFirst(int value) {
    	Node e=new Node(value);
    	if(isEmpty()) {
    		first=e;
    		last=e;
    	}
    	else {
    		first.pre=e;
    		e.next=first;
    		first=e;
    	}
    	return e;
    }
    public void popLast() throws Exception {
    	if(isEmpty()) {
    		throw new Exception("不能删除");
    	}
    	//只有一个结点
    	else if(first==last){
    		first=last=null;
    	}
    	else {
    		last=last.pre;
    		last.next=null;
    	}
    }
    public void popFirst() throws Exception{
    	if(isEmpty()) {
    		throw new Exception("不能删除");
    	}
    	else if(first==last){
    		first=last=null;
    	}
    	else {
    		first=first.next;
    		first.pre=null;
    	}
    }
	private  void print() {
		// TODO 自动生成的方法存根
		Node head=first;
		while(head!=null) {
			System.out.println(head.val+"->");
			head=head.next;
		}
		System.out.println("_______");
	}
	private  void printReverse() {
		// TODO 自动生成的方法存根
		Node head=last;
		while(head!=null) {
			System.out.println(head.val+"->");
			head=head.pre;
		}
		System.out.println("******");
	}
    public static void main(String[] args) throws Exception {
    	Test2 l=new Test2();
    	l.addFirst(1);
    	l.print();
    	l.printReverse();
    	l.addLast(2);
    	l.printReverse();
    	l.print();
    	l.addFirst(3);
    	l.popFirst();
    	l.print();
    	l.popLast();
    	l.print();
        l.popLast();
        l.print();
    }

}
   
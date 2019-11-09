package test_94;
import java.util.*;
class Node{
	public int val;
	public Node next;
	public Node random;
	Node(int val,Node next,Node random){
		this.val=val;
		this.next=next;
		this.random=random;
	}
	public Node() {
		// TODO 自动生成的构造函数存根
	}
}
public class Copyset {
Node copy(Node head) {
	Node p=head;
	Node result=null;
	Node last=null;
	Map<Node,Node> map=new HashMap<>();
	while(p!=null) {
		Node q=new Node();
		q.val=p.val;
		if(result==null)
			result=q;
		else {
			last.next=q;
		}
		last=q;
		map.put(p,q);
		p=p.next;
	}
	p=head;
	Node q=result;
	while(p!=null) {
		q.random=map.get(p.random);
		p=p.next;
		q=q.next;
	}
 return result;
}
}

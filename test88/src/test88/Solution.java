package test88;//妹妹
class Node {
    int val;
    Node next;
    Node (int val){
	    this.val=val;
    }
}
//random指针指向任意一个结点，（构造和一般Node一样，多了一个random）
class CNode {
	int val;
	CNode random;
	CNode next;
	CNode(int val) {
		this.val = val;
	}
}
//写一个函数（类）处理
class ASolution {
	//reverselist用来逆置链表
	//回顾之前写过的代码reverse与reverselist原理一致
//	Node reverse(Node head) {
//		Node pre=null;
//		while(head!=null) {
//		Node next=head.next;
//		head.next=pre;
//		pre=head;
//		head=next;
//		}
//		return pre;
//	}
	Node reverseList(Node head) {
		Node result = null;	
		Node cur = head;
		while (cur != null) {
			Node next = cur.next;

			cur.next = result;
			result = cur;

			cur = next;
		}

		return result;
	}

	Node removeAll(Node head, int val) {
		if (head == null) {
			return null;
		}

		Node prev = head;
		Node cur = head.next;

		while (cur != null) {
			if (cur.val == val) {
				prev.next = cur.next;
			} else {
				prev = cur;
			}

			cur = cur.next;
		}

		if (head.val == val) {
			return head.next;
		}

		return head;
	}
	//有序链表的链接
    Node mergelist(Node head1,Node head2){
    	if(head1==null) return head2;
    	if(head2==null) return head1;
    	Node result=null;//无法判定head1的值小还是head2小，所以引入一个result，
    	Node last=null;//核心指针，通过变动last.next完成链表
    	//当然你也可以先判断哪一个值小就return head1或和head2，这里result可以不出现
    	//先假设两个链表长度相等，处理这种情况
    	Node cur1=head1;
		Node cur2=head2;
		/*
		 while(head1!=null&&head2!=null){
		 if(head1.val<head2.val){
		   if(result==null){
		   result=cur1;
		   }
		   else{
		   last.next=cur1;
		   }
		   last=cur1;
		   cur1=cur1.next;
		   }
		   else{
		   if(result==null){
		   result=cur2;
		   }
		   else{
		   last.next=cur2;
		   }
		   last=cur2;
		   cur2=cur2.next;
		   }
		   }
		*/
    	while(head1!=null&&head2!=null) {
    		if(head1.val<=head2.val) {//小于等于是一般习惯，如果两者值相等，先走head1引导的链表
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
    	if(cur2==null) last.next=cur1;
    	return result;
    }
	Node merge(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}

		if (head2 == null) {
			return head1;
		}

		Node result = null;
		Node last = null;

		Node cur1 = head1;
		Node cur2 = head2;

		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				if (result == null) {
					result = cur1;
				} else {
					last.next = cur1;
				}

				last = cur1;
				cur1 = cur1.next;
			} else {
				if (result == null) {
					result = cur2;
				} else {
					last.next = cur2;
				}

				last = cur2;
				cur2 = cur2.next;
			}
		}

		if (cur1 == null) {
			last.next = cur2;
		} else {
			last.next = cur1;
		}

		return result;
	}

	Node deleteDuplicate(Node head) {
		if (head == null) {
			return null;
		}

		Node prev = null;
		Node p1 = head;
		Node p2 = head.next;

		while (p2 != null) {
			if (p1.val != p2.val) {
				prev = p1;
				p1 = p2;
				p2 = p2.next;
			} else {
				while (p2 != null && p2.val == p1.val) {
					p2 = p2.next;
				}

				if (prev == null) {
					head = p2;
				} else {
					prev.next = p2;
				}

				p1 = p2;
				if (p2 != null) {
					p2 = p2.next;
				}
			}
		}

		return head;
	}

	CNode copy(CNode head) {
		if (head == null) {
			return null;
		}

		CNode cur = head;
		while (cur != null) {
			CNode node = new CNode(cur.val);

			node.next = cur.next;
			cur.next = node;

			cur = node.next;
		}

		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}

			cur = cur.next.next;
		}

		CNode newHead = head.next;
		cur = head;

		while (cur != null) {
			CNode node = cur.next;

			cur.next = node.next;
			if (node.next != null) {
				node.next = node.next.next;
			}

			cur = cur.next;
		}

		return newHead;
	}
}









public class Solution {
	static void testReverseList() {
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(6);
		Node n4 = new Node(9);
		Node n5 = new Node(2);
		Node n6 = new Node(5);
		Node n7 = new Node(8);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		Node result = new ASolution().reverseList(n1);

		for (Node cur = result; cur != null; cur = cur.next) {
			System.out.printf("%d --> ", cur.val);
		}
		System.out.println();


		result = new ASolution().reverseList(null);

		for (Node cur = result; cur != null; cur = cur.next) {
			System.out.printf("%d --> ", cur.val);
		}
		System.out.println();
	}

	static void testCopy() {
		CNode n1 = new CNode(1);
		CNode n2 = new CNode(2);
		CNode n3 = new CNode(3);
		CNode n4 = new CNode(4);

		n1.next = n2; n2.next = n3; n3.next = n4;
		n1.random = n2; n2.random = n1; n3.random = n3;

		CNode result = new ASolution().copy(n1);
		for (CNode cur = n1; cur != null; cur = cur.next) {
			System.out.printf("CNode(%s, %d, %s) --> %n",
				cur, cur.val, cur.random);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();


		for (CNode cur = result; cur != null; cur = cur.next) {
			System.out.printf("CNode(%s, %d, %s) --> %n",
				cur, cur.val, cur.random);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		testReverseList();
		testCopy();
	}
}


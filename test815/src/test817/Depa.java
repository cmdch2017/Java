package test817;
class Node {
    int val;
    Node next = null;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
//DEPART
public class Depa{
	public static Node clone(Node head,int key) {
		Node cur=head;
		Node small=null;
		Node big=null;
		Node smallLast=null;
		Node bigLast=null;
		if(head==null) return null;
		while(cur!=null) {
			if(cur.val<key) {
				if(small==null)
				small=cur;
				else {
					smallLast.next=cur;
				}
				smallLast=cur;
				cur=cur.next;
			}
			else {
				if(cur.val<key) {
					if(small==null)
					small=cur;
					else {
						smallLast.next=cur;
					}
					smallLast=cur;
					cur=cur.next;
				}
			}
			
		}
		if(smallLast==null) {
			return big;
		}
		else {
			smallLast.next=big;
		}
		{
			return small;
		}
	}
    private static Node separate(Node head, int x) {
        // �Ѷȣ�β��
        Node cur = head;
        Node small = null;
        Node smallLast = null;
        Node big = null;
        Node bigLast = null;

        while (cur != null) {
            if (cur.val < x) {
                // �� cur β�嵽 small
                if (small == null) {
                    small = cur;
                } else {
                    smallLast.next = cur;
                }
                smallLast = cur;
            } else {
                // �� cur β�嵽 big
                if (big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = cur.next;
        }

        // �� big �ӵ� small �ĺ��
        if (smallLast == null) {
            return big;
        } else {
            smallLast.next = big;
        }

        if (bigLast == null) {
            return small;
        } else {
            bigLast.next = null;
        }

        return small;
        // ����.����
        // ����.����
        // NullPointerException��û�ж���
        // ���� == null
        // 1. ���������ҵ�����
        // 2. ���ʶ�������Ի��ߵ��ö���ķ���
    }

    private static Node createList() {
        Node n1 = new Node(1);
        Node n2 = new Node(9);
        Node n3 = new Node(9);
        Node n4 = new Node(7);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        Node n8 = new Node(1);

        n1.next = n2; n2.next = n3; n3.next = n4;
        n4.next = n5; n5.next = n6; n6.next = n7;
        n7.next = n8;

        return n1;
    }

    public static void main(String[] args) {
        Node head = createList();
        Node rhead = separate(null, 7);
        for (Node c = rhead; c != null; c = c.next) {
            System.out.println(c);
        }
    }
}

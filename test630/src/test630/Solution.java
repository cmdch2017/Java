package test630;
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
	this.val=val;
	}
}
public class Solution {
	//删除单链表中的重复节点
	public static ListNode deleteDuplication(ListNode pHead)
	{
	    if(pHead==null)
	        return pHead;
	    ListNode first = new ListNode(0);
	    first.next = pHead;
	    ListNode p = pHead;
	    ListNode pre = first;
	    while (p != null && p.next != null){
	        if(p.val == p.next.val) {
	           int val = p.val;

	            //只需把下面的while改为注释的while，即可由情形1得到2
	           /*
	             while(p.next != null && p.next.val == val) {
	                p.next = p.next.next;
	            }
	            */

	            while(p != null && p.val == val) {
	                p = p.next;
	            }

	            pre.next = p;
	        }else {
	            pre= p;
	            p = p.next;
	        }
	    }
	    while(first.next != null) {
	        System.out.print(first.next.val + " ");
	        first = first.next;
	    }
	    return first.next;
	}

	public static void main(String[] args) {
	    //-构造单链表start----
	    int[] num = { 2, 3, 3, 5, 7, 8, 8, 8, 9, 9, 10 }; 
	    ListNode head = new ListNode(num[0]);
	    ListNode pre = head;
	    for (int i = 1; i < num.length; i++) {
	        ListNode node = new ListNode(num[i]);
	        pre.next = node;
	        pre = node;
	    }
	    //-构造单链表end-----

	    deleteDuplication(head);
	}

}

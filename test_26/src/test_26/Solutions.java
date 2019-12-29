package test_26;
 class ListNode {     
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solutions {
   public ListNode removeElements(ListNode head, int val) {
       if(head==null) return null;
       ListNode newHead=new ListNode(val+1);
       newHead.next=head;
       ListNode p=newHead;
       ListNode q=head;
       while(q!=null) {
	       while(q!=null&&q.val!=val) {
	    	   p=p.next;
	    	   q=q.next;
	       }
	       if(q==null) break;
	       q=q.next;
	       p.next=q;
       }
       return newHead.next;
   }
}
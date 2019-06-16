import java.util.*;
public class ƒÊ÷√¡¥±Ì {
    int val;
    ListNode next = null;
public ListNode reverse(ListNode head){
    ListNode pre=null;
    ListNode next=null;
    for(ListNode cur=head;cur!=null;cur=cur.next){
        next=cur.next;
        cur.next=pre;
        pre=cur;
        cur=next;
    }
    return pre;
}
}
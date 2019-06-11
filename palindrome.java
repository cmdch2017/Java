// 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
// 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
// 测试样例：
// 1->2->2->1
// 返回：true
import java.util.*;
 
public class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}
public class PalindromeList {
    public ListNode getMid(ListNode head){
    ListNode fast=head;
    ListNode low=head;
    while(fast!=null){
        fast=fast.next;
        if (fast==null){ 
            break;
            }
        low=low.next;
        fast=fast.next;
    }
    return low;
}
     
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
    public boolean chkPalindrome(ListNode A) {
        // write code here
        ListNode mid=getMid(A);
        ListNode h2=reverse(mid);
        ListNode n1=A;
        ListNode n2=h2;
        while(n1!=null&&n2!=null){
            if(n1.val!=n2.val){
                return false;
            }
            n1=n1.next;
            n2=n2.next;
        }
        return true;
    }
}
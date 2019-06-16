// 瀵逛簬涓�涓摼琛紝璇疯璁′竴涓椂闂村鏉傚害涓篛(n),棰濆绌洪棿澶嶆潅搴︿负O(1)鐨勭畻娉曪紝鍒ゆ柇鍏舵槸鍚︿负鍥炴枃缁撴瀯銆�
// 缁欏畾涓�涓摼琛ㄧ殑澶存寚閽圓锛岃杩斿洖涓�涓猙ool鍊硷紝浠ｈ〃鍏舵槸鍚︿负鍥炴枃缁撴瀯銆備繚璇侀摼琛ㄩ暱搴﹀皬浜庣瓑浜�900銆�
// 娴嬭瘯鏍蜂緥锛�
// 1->2->2->1
// 杩斿洖锛歵rue

 class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}
 class PalindromeList {
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
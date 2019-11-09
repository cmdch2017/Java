package addlist;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//两个链表的第一个公共结点
//运行问题：空指针
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 int count1=0,count2=0,count=0;
 if(pHead1==null) return null;
 if(pHead2==null) return null;
        while(pHead1!=null){
            pHead1=pHead1.next;
            count1++;
        }
        while(pHead2!=null){
            pHead2=pHead2.next;
            count2++;
        }
        count=count1-count2;
        if(count>0){
            for(int i=0;i<count;i++){
                pHead1=pHead1.next;
            }
        }
        if(count<0){
            for(int i=0;i<-count;i++){
                pHead2=pHead2.next;
            }
        }
        ListNode p=pHead1;
        ListNode q=pHead2;
        if(p.next==null) 
        {
        	if(p==q) return p;
            return null;
        }
        while(p.next!=null){
        if(p.next==q.next){
            return p.next;
        }
            p=p.next;
            q=q.next;
        }
        return null;
    }
}
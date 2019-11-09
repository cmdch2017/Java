package test923;


import java.io.IOException;

/**
 * @author 
 * @date 2018/4/2  22:15
 */

public class DoublyLinkList<T>{
    private Link<T> frist;
    private Link<T> last;
    public DoublyLinkList(){//初始化首尾指针
        frist = null;
        last = null;
    }

    public boolean isEmpty(){
        return frist == null;
    }

    public void addFrist(T value){
        Link<T> newLink= new Link<T>(value);
        if(isEmpty()){ // 如果链表为空
            last = newLink; //last -> newLink
        }else {
            frist.pre = newLink; // frist.pre -> newLink
        }
        newLink.next = frist; // newLink -> frist
        frist = newLink; // frist -> newLink
    }

    public void addLast(T value){
        Link<T> newLink= new Link<T>(value);
        if(isEmpty()){ // 如果链表为空
            frist = newLink; // 表头指针直接指向新节点
        }else {
            last.next = newLink; //last指向的节点指向新节点
            newLink.pre = last; //新节点的前驱指向last指针
        }
        last = newLink; // last指向新节点
    }

    public boolean addBefore(T key,T value){

        Link<T> cur = frist;
        if(frist.next.val == key){
            addFrist(value);
            return true;
        }else {
            while (cur.next.val != key) {
                cur = cur.next;
                if(cur == null){
                    return false;
                }
            }
            Link<T> newLink= new Link<T>(value);
            newLink.next = cur.next;
            cur.next.pre = newLink;
            newLink.pre = cur;
            cur.next = newLink;
            return true;
        }
    }

    public void addAfter(T key,T value)throws RuntimeException{
        Link<T> cur = frist;
        while(cur.val!=key){ //经过循环，cur指针指向指定节点
            cur = cur.next;
            if(cur == null){ // 找不到该节点
                throw new RuntimeException("Node is not exists");
            }
        }
        Link<T> newLink = new Link<>(value);
        if (cur == last){ // 如果当前结点是尾节点
            newLink.next = null; // 新节点指向null
            last =newLink; // last指针指向新节点
        }else {
            newLink.next = cur.next; //新节点next指针，指向当前结点的next
            cur.next.pre = newLink; //当前结点的前驱指向新节点
        }
        newLink.pre = cur;//当前结点的前驱指向当前结点
        cur.next = newLink; //当前结点的后继指向新节点
    }

    public void deleteFrist(){
        if(frist.next == null){
            last = null;
        }else {
            frist.next.pre = null;
        }
        frist = frist.next;
    }

    public void deleteLast(T key){
        if(frist.next == null){
            frist = null;
        }else {
            last.pre.next = null;
        }
            last = last.pre;
    }

    public void deleteKey(T key)throws RuntimeException{
        Link<T> cur = frist;
        while(cur.val!= key){
            cur = cur.next;
            if(cur == null){ //不存在该节点
                throw new RuntimeException("Node is not exists");
            }
        }
        if(cur == frist){ // 如果frist指向的节点
            frist = cur.next; //frist指针后移
        }else {
            cur.pre.next = cur.next;//前面节点的后继指向当前节点的后一个节点
        }
        if(cur == last){ // 如果当前节点是尾节点
            last = cur.pre; // 尾节点的前驱前移
        }else {
            cur.next.pre = cur.pre; //后面节点的前驱指向当前节点的前一个节点
        }
    }

    public T queryPre(T value)throws IOException,RuntimeException{
        Link<T> cur = frist;
        if(frist.val == value){
            throw new RuntimeException("Not find "+value+"pre");
        }
        while(cur.next.val!=value){
            cur = cur.next;
            if(cur.next == null){
                throw new RuntimeException(value +"pre is not exeist!");
            }
        }

        return cur.val;
    }

    public void displayForward(){
        Link<T> cur = frist;
        while(cur!=null){
            cur.displayCurrentNode();
            cur = cur.next;
        }
        System.out.println();

    }
    public void displayBackward(){
        Link<T> cur = last;
        while(cur!=null){
            cur.displayCurrentNode();
            cur = cur.pre;
        }
        System.out.println();
    }

    public void test()throws Exception{ // 自己测试代码
        DoublyLinkList<Integer> d = new DoublyLinkList<Integer>();
        d.addFrist(1);
//        d.addFirst(1);
        d.addFrist(2);
        d.addFrist(3);
        d.addLast(6);
        d.addFrist(4);
        d.addFrist(5);
        d.addLast(7);
        d.displayForward();
        System.out.println(d.queryPre(4));
        System.out.println(d.queryPre(0));
    }
}

class Link <T>{
    public T val;
    public Link<T> next;
    public Link<T> pre;

    public Link(T val) {
        this.val = val;
    }

    public void displayCurrentNode() {
        System.out.print(val + "  ");
    }
    public static void main(String[] args) throws Exception {
    	
    }
}

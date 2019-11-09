package test_911;

import java.lang.reflect.Array;

class Node{
	int key;
	int value;
}/*
public class Solution {
private int remove(int key) {
	int index=hashFunction(key,array.length);
	Node head=array[index];
	Node pre=null;
	Node cur=head;
	int [] array;
	while(cur!=null) {
		if(cur.key==key) {
			int oldValue=cur.value;
			if(cur==head) {
				array[index]=array[index].next;
			}
			else {
				pre.next=cur.next;
			}
			size--;
			return oldValue;
			/*if(pre==null) {
				pre=head.next;
			}
			else {
				pre.next=cur.next;
			}
		}
		cur=cur.next;
	}
	return -1;
}*/


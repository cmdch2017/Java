package test_823;

public class MyCircularQueue {
private int[] array;
int front=0;
int rear=0;
int size=0;
public MyCircularQueue(int k) {
	array=new int[k];
}
public boolean enQueue(int value) {
	if(array.length==size) {
		return false;
	}
	array[rear]=value;
	rear=(rear+1)%array.length;
	size++;
	return true;
}
public int front() {
	return array[front];
}
public int rear() {
	int index=(rear-1+array.length)%array.length;
	return array[index];
}
public boolean deQueue() {
	if(size==0)
		return false;
	front=(front+1)%array.length;
	size--;
	return true;
}
}

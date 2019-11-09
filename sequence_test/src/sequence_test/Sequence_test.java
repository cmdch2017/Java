package sequence_test;
import java.util.Arrays;
public class Sequence_test {
private int[] array;
private int size;//ʵ�ʴ�С
public Sequence_test() {
	 array=new int[3];
	 size=0;
}
public void pushFront(int element) {
	ensurecapacity();
	for(int i=size;i>0;i--) {
		array[i]=array[i-1];
	}
	array[0]=element;
	size++;
}
public String toString() {
	return Arrays.toString(Arrays.copyOf(array,size));
}
public void ensurecapacity() {
	if(size<array.length) {
		return ;
	}
	int newlength=array.length*3;
	int[] newArray=new int[newlength];
	for(int i=0;i<array.length;i++) {
		newArray[i]=array[i];
	}
	this.array=newArray;
	}
public static void main (String[] args) {
	Sequence_test list=new Sequence_test();
	list.pushFront(20);
	list.pushFront(10);
	list.pushFront(10);
	list.pushFront(10);
	list.pushFront(10);
	list.pushFront(10);
	list.pushFront(10);
	System.out.println(list.toString());
}
}

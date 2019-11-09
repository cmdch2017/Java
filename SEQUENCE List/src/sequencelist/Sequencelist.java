package sequencelist;

import java.util.Arrays;

public class Sequencelist {
	//属性
	private int[] array;//用来保存数据
	private int size;
public Sequencelist() {
array=new int[11];
size=0;//实际元素个数
}
public void pushFront(int element) {
	ensureCapcity();
	for(int i=size-1;i>=0;i--) {
		array[i+1]=array[i];
	}
	array[0]=element;
	size++;
}
public void pushBack(int element) {
	array[size++]=element;
}
public void insert(int index,int element) {
	//size-1为最后实际数字的下标
	for(int i=size-1;i>=index;i--) {
		array[i+1]=array[i];
	}
	array[index]=element;
	size++;
}
public void popFront() {
	for(int i=0;i<size-1;i++) {
		array[i]=array[i+1];
	}
	size--;
}
public void popBack() {
	array[--size]=0;
}
public int[] getArray() {
	return array;
}
public void setArray(int[] array) {
	this.array = array;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public void erase(int index) {
	//中间删除
	if(index<0||index>=size) {
		return;
	}
	for(int i=index;i<size;i++) {
		array[i]=array[i+1];
	}
	size--;
}
public int indexOf(int element) {
	for(int i=0;i<size;i++) {
		if(array[i]==element)
			return i;
	}
		return -1;
}
public int get(int index) {
	return array[index];
};
public void set(int index,int element) {
	array[index]=element;
}
public String toString() {
	return Arrays.toString(Arrays.copyOf(array,size));
	//original the array to be copiednewLength the length of the copy to be returned
	//a copy of the original array
}
private void ensureCapcity() {
	if(size<array.length) {
		//不需要扩容
		return;
	}
	//申请新房子
	int newCapacity=array.length+array.length/2;
	int[] newArray=new int[newCapacity];
	//搬家
	for(int i=0;i<size;i++) {
		newArray[i]=array[i];
	}
	//发朋友圈
	this.array=newArray;
}
public void remove(int element) {
int index=indexOf(element);
if(index!=-1) {
	erase(index);
}
}
//o(n^2)
public void removeAll(int element) {
	int index;
	while((index=indexOf(element))!=-1) {
		erase(index);
	}
}
//o(n)

public void removeAll2(int element) {
	int[] newArray=new int[size];
	int j=0;
	for(int i=0;i<size;i++)
	{
		if(array[i]!=element) {
			newArray[j++]=array[i];
		}
	}
	for(int i=0;i<j;i++) {
		array[i]=newArray[i];
	}
	size=j;
}
public void removeAll3(int element) {
int j=0;
for(int i=0;i<size;i++) {
	if(array[i]!=element) {
		array[j++]=array[i];
	}
}
size=j;
}
public static void main(String[] args) {
	Sequencelist seqList=new Sequencelist();
	System.out.println(seqList.toString());
	seqList.pushBack(1);
	seqList.pushBack(2);
	seqList.pushBack(3);
	System.out.println(seqList.toString());
	seqList.pushFront(10);
	seqList.pushFront(20);
	seqList.pushFront(30);
	int ret=seqList.indexOf(100);
	System.out.println(ret);
	System.out.println(seqList.toString());
	seqList.insert(2, 100);
	seqList.insert(4, 200);
	System.out.println(seqList.toString());
	seqList.erase(10);
	System.out.println(seqList.toString());
	seqList.popFront();
	System.out.println(seqList.toString());
	seqList.popBack();
	System.out.println(seqList.toString());
	seqList.set(1, 60000);
	int getNumber=seqList.get(0);
	System.out.println(getNumber);
	seqList.removeAll3(1);
	//seqList.erase(1);
	System.out.println(seqList.toString());
}
}

package test816_2;

import java.util.Arrays;

public class Tree {
int[] h=new int[101];//存放堆的数组
static int n=6;//存放堆的个数
public void swap(int x,int y) {
	int t;
	t=h[x];
	h[x]=h[y];
	h[y]=t;
}
private void siftdown(int i) {
	int t,flag=0;
	while(i*2<=n&&flag==0) {
		if(h[i]>h[i*2])
			t=i*2;
		else
			t=i;
		if(2*i+1<=n) {
			if(h[t]>h[2*i+1])
				t=2*i+1;
		}
		if(t!=i) {
			swap(t,i);
			i=t;
		}
		else
			flag=1;
	}
}
public void create(){
	int i;
	for(i=n/2;i>=1;i--) {
	siftdown(i);	
	}
}
int deletemax() {
	int t;
	t=h[1];
	h[1]=h[n];
	n--;
	siftdown(1);
	return t;
}
public static void main(String[] args) {
	int num=6;//假设总共六个数，分别是99，5，6，9，79，10
	int[] h=new int[10];
	h[1]=99;
	h[2]=5;
	h[3]=6;
	h[4]=9;
	h[5]=79;
	h[6]=10;
	Tree t=new Tree();
	n=num;
	t.create();
for(int i=1;i<=6;i++) {
System.out.println(t.deletemax());
}
}
}

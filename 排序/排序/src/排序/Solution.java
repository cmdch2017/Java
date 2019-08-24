package 排序;

import java.util.Arrays;
//什么是有序序列？无序序列？
//有序序列是已经排好的数据的集合，无序序列就是还未排好，或者准备排序的集合
//什么是减治算法
//顾名思义就是每次遍历（循环）,数据规模都逐渐减小，
//例如选择排序，每次挑选一个最大的放入有序序列，无序序列减小，
//又例插入排序中每一次取一个元素与已经排好的序列进行比较
//减治算法典型的算法举例
//选择和插入排序
//在代码里有什么体现
//外层循环-1，内层不变
public class Solution {
public static void insert(int[] array) {
	//减治算法外层循环长度-1
	for(int i=0;i<array.length-1;i++) {
		//有序区间 [0,i]
		//无需区间 [i+1,length)
		int j;int key=array[i+1];//key在无序区间首元素
		//从后向前遍历
		for(j=i;j>=0;j--) {
			if(array[j]<=key) break;
			//搬家
			array[j+1]=array[j];
		}
		//跳出循环发朋友圈赋值
		array[j+1]=key;
	}
}
public static void shell(int[] array) {
	int gap=array.length;
	while(true) {
	gap/=2;
	insertwithGap(array,gap);
	if(gap==1) break;
	}
}
private static void insertwithGap(int[] array,int gap) {
	//减治算法外层循环长度-1
	for(int i=0;i<array.length-gap;i++) {
		//有序区间 [0,i]
		//无需区间 [i+1,length)
		int j;int key=array[i+gap];//key在无序区间首元素
		//从后向前遍历
		for(j=i;j>=0;j-=gap) {
			if(array[j]<=key) break;
			//搬家
			array[j+gap]=array[j];
		}
		//跳出循环发朋友圈赋值
		array[j+gap]=key;
	}
}
//选择排序（数据不敏感的排列方式）
public static void chooseMax(int[] array) {
	//减治算法外层循环长度-1
	for(int i=0;i<array.length-1;i++) {
		int max=0;//假设第一个元素最大,max下标记作0
		//无数认识到减治算法大的人会将这里写成j<array.length-1-i
		//但如此首元素就会被忽视，所以如果初次学习，可以忽视减治算法外层循环长度-1的优化
		for(int j=1;j<array.length-i;j++) {
			if(array[max]<array[j])
				max=j;
		}
		//跳出循环找到最大值max交换
		wrap(array,array.length-1-i,max);//目的最大元素放到最后
	}
}
public static void wrap(int[] array, int i, int k) {
	// TODO 自动生成的方法存根
	int t;
	t=array[i];
	array[i]=array[k];
	array[k]=t;
}
public static void heapSort(int[] array) {
	//建立一个堆
	createHeap(array);
	//减治算法外层循环-1
	for(int i=0;i<array.length-1;i++) {
		//找到最大值max交换，这里大堆，下标0处为最大元素
		wrap(array,array.length-1-i,0);
		heapify(array,array.length-i-1,0);
	}
}
private static void heapify(int[] array, int size, int index) {
	// TODO 自动生成的方法存根
	//（是否是叶子节点）判断是否越界
	//max记录：比较左右孩子谁大
	//max与index比较是否需要交换（建立大堆，如果array[index]<array[max]需要交换，否则不需要）
	//违反下标规则
	if(size<=index) return;
	while(true) {
		int leftchild=2*index+1;
		int rightchild=2*index+2;
		if(leftchild>=size) return;//左孩子存在
		int max=leftchild;
		if((rightchild<size)&&(array[leftchild]<array[rightchild]))
			max=rightchild;
	    //注意这里返回
		if(array[index]>=array[max]) {return;}
	    	wrap(array,index,max);
	    	index=max;
	    	}
	}
/*private static void createHeap(int[] array) {
	// TODO 自动生成的方法存根
	//最后一个父节点开始遍历调整
	int parents=(array.length-1-1)/2;
	for(int i=parents;i>=0;i--) {
		heapify(array,i,0);
	}
	
}*/
private static void createHeap(int[] array) {
	// TODO 自动生成的方法存根
	//最后一个父节点开始遍历调整
	int parent=(array.length-1-1)/2;
	for(int i=parent;i>=0;i--) {
		heapify(array,array.length,i);//数组，实际长度，调整下标位置
	}
	
}
public static void main(String[] args) {
	int[] array1= {8,1,2,3,4,9,5,6,3};
	int[] array2= {9,8,7,6,5,4,3,2,1};
	int[] array3= {8,1,2,3,4,9,5,6,3};
	int[] array= {9,8,7,6,5,4,3,2,1};
	//插入排序
	insert(array1);
	//选择排序（选择最大）
	chooseMax(array2);
	//希尔排序
	shell(array3);
	//堆排序
	heapSort(array);
	System.out.println(Arrays.toString(array1));
	System.out.println(Arrays.toString(array2));
	System.out.println(Arrays.toString(array3));
	System.out.println(Arrays.toString(array));
}
}

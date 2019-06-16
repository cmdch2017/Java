package Bubble2;

import java.util.Arrays;

public class Bubble2 {
	public static void swap(int array[],int i,int j) {
		int temp=0;
		temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
static void bubbleSort(int[] array) {
	for(int i=0;i<array.length;i++) {
		for(int j=0;j<array.length-i-1;j++)
			if(array[j]>array[j+1])
			swap(array,j,j+1);
	}
}
static int binarySearch(int[] array,int key,int left,int right) {
	int mid=(left+right)/2;
	while(left<right) {
		if(array[mid]==key) {return mid;}
		if(array[mid]<key) {left=mid+1;}
		if(array[mid]>key) {right=mid-1;}
		
	}
	return -1;
}
public static void main(String[] args) {
	int[] array= new int[] {6,2,3,9,8,5,0,2};
	bubbleSort(array);
	System.out.println(Arrays.toString(array));
	int ret=0;
	ret=binarySearch(array,3,0,7);
	System.out.println(ret);
}
}

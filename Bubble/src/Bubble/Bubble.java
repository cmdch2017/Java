package Bubble;

import java.util.Arrays;


public class Bubble {
public static void swap(int[] array,int i,int j) {
	int t=array[i];
	array[i]=array[j];
	array[j]=t;
}
static boolean isSwapped=false;//如果为123456未改变顺序，直接输出
public static void bubble(int[] array) {
	for(int i=0;i<array.length;i++) {
		for(int j=0;j<array.length-i-1;j++) {
		if(array[j]>array[j+1]) {
			swap(array,j,j+1);
			isSwapped=true;
			}
		}
		if(!isSwapped) {
			return;
		}
	}
}
public static void bubble1(int[] array) {
	for(int i=0;i<array.length;i++) {
		for(int j=0;j<array.length-1-i;j++) {
			if(array[j]>array[j+1])
			swap(array,j,j+1);
		}
	}
}
public static void main(String[] args) {
	int array[]= new int[]{9,2,8,4,5,6};
	//bubble(array);
	bubble1(array);
	System.out.println(Arrays.toString(array));
}
}
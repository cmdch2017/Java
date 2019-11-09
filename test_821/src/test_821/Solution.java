package test_821;

import java.lang.reflect.Array;
import java.util.Arrays;
public class Solution {
	//Java 中形参是如何传入的？为什么可以返回A【array.length】
public void quickSort(int A[],int left,int right) {
	//6 5 3 2 1 8 9
	int tempLeft=left;
	int tempRight=right;
	int temp=left;//基准值
	while(tempLeft!=tempRight) {
		if(tempLeft>tempRight) {
			break;
		}
		//右侧找到小于标准的值
		while(temp<A[tempRight]) {
			tempRight--;
		}
		//左侧找到大于标准的值
		while(temp>A[tempLeft]) {
			tempLeft++;
		}
		//交换
		if(tempLeft<tempRight) {
			int a=A[tempLeft];
			A[tempLeft]=A[tempRight];
			A[tempRight]=a;
		}
		tempRight--;
		tempLeft++;
	}
	quickSort(A,left,tempLeft-1);
	quickSort(A,tempLeft+1,right);
}
public void bubbleSort(int[] A) {
	for(int i=0;i<A.length;i++) {
		for(int j=i;j<A.length;j++) {
			if(A[i]>A[j]) {
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
		
	}
}
public int largestPerimeter(int[] A) {
	Arrays.sort(A);//加入输入4 2 3 1    先排序 1 2 3 4
	for(int i=Array.getLength(A)-1-2;i>0;i--) {
		//如果两边之和大于第三边就返回正确
		if(A[i+2]<A[i+1]+A[i])
		{
			return A[i+2]+A[i+1]+A[i];
		}
	}
	return 0;
}
public static void main(String[] args) {
	int[] array= {1,3,5,2,8};
	Solution l=new Solution();
	l.bubbleSort(array);
	for(int i=0;i<array.length;i++)
	System.out.println(array[i]);
	int result=l.largestPerimeter(array);
	for(int i=0;i<array.length;i++)
	System.out.println(array[i]);
	System.out.println(result);
}
}
//ABDGKHLEIMNPCFJO
//GKDLHBEMINPACFOJ
//KGLHDMPNIEBOJFCA

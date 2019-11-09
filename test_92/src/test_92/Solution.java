package test_92;
import java.util.*;
class Person{
	String name;
	int age;
}
public class Solution {
	public static void mergeSort(int[] array) {
		mergeSortInner(array,0,array.length-1);
	}
	private static void mergeSortInner(int[] array, int low, int high) {
		// TODO 自动生成的方法存根
		//跳出条件length<=1
		//左右俩快分裂治之，合并
		if(low+1>=high) {
			return;
		}
		int mid=(low+high)/2;
		mergeSortInner(array,low,mid);
		mergeSortInner(array,mid,high);
		merge(array,low,mid,high);
	}
	private static void merge(int[] array, int low, int mid, int high) {
		int length=high-low;
		int[] extra=new int[length];
		//[low,mid)
		//[mid,high)
		int left=low;
		int right=mid;
		int iExtra=0;
		while(left<mid && right<high) {
			if(array[left]<=array[right]) {
				extra[iExtra++]=array[left++];
			}
			else {
				extra[iExtra++]=array[right++];
			}
		}
		while(left<mid) {
			extra[iExtra++]=array[left++];
		}
		while(right<high) {
			extra[iExtra++]=array[right++];
		}
			for(int i=0;i<length;i++) {
				array[low+i]=extra[i];
			}
		
	}
	public static void main(String[] args) {
		Person[] people=new Person[20];
		Random random=new Random(2019);
		
	//	int[] array= {3,2,6,8,1,9};
	//	mergeSort(array);
		//System.out.println(Arrays.toString(array));
	}
}

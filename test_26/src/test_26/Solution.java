package test_26;

public class Solution {
	public static void main(String[] args) {
		int[] array= {9,3};
		Solution l=new Solution();
		//l.heapSort(array);
		for(int i:array) {
			System.out.print(i+" ");
		}
	}
	/*
	public void bubbleSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			//外层for循环作用：调整无序序列的长度/次数
			for(int j=0;j<array.length-1-i;j++) {
				//每次从头到已有序位置前一个进行排序
				if(array[j]>array[j+1])
					swap(array,j,j+1);
			}
		}
	}
		public  void heapSort(int[] array) {
		createHeap(array);
		for (int i = 0; i < array.length - 1; i++) {
			swap(array, 0, array.length-i-1);
			shiftDown(array, array.length - i - 1, 0);
		}
		}
		private  void swap(int[] array, int i, int j) {
			int t = array[i];
			array[i] = array[j];
			array[j] = t;
		}
		private static void createHeap(int[] array) {
			for (int i = (array.length - 1) / 2; i >= 0; i--) {
				shiftDown(array, array.length, i);
			}
		}
		public static void shiftDown(int[] array, int size, int index) {
			int left = 2 * index + 1;
			while (left < size) {
			int max = left;
			int right = 2 * index + 2;
			if (right < size) {
			if (array[right] > array[left]) {
			max = right;
		}
			}
			if (array[index] >= array[max]) {
			break;
}
			int t = array[index];
			array[index] = array[max];
			array[max] = t;
			index = max;
			left = 2 * index + 1;
		}
		}
		*/
}

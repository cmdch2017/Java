package test_26;

public class SolutionReview {
	public static void main(String[] args) {
		int[] array=new int[100];
		for(int i=0;i<100;i++) {
			array[i]=(int) (Math.random()*100+1);
		}
		SolutionReview l=new SolutionReview();
			l.mergeSort(array);
		for(int i:array) {
			System.out.print(i+" ");
		}
	}
	public static void quickSort(int[] array) {
		quickSortInternal(array,0,array.length-1);
	}
	private static void quickSortInternal(int[] array, int left, int right) {
		// TODO 自动生成的方法存根
		if(left>=right) return;
		int i=left,j=right;
		int pivot=partition(array,left,right);
		quickSortInternal(array,left,pivot-1);
		quickSortInternal(array,pivot+1,right);
	}
	private static int partition(int[] array, int left, int right) {
		// TODO 自动生成的方法存根
		int i=left,j=right;
		int pivot=left;
		while(i<j) {
			while(i<j&&array[j]>=array[pivot]) {
				j--;
			}
			while(i<j&&array[i]<=array[pivot]) {
				i++;
			}
			swap(array,i,j);
		}
		swap(array,i,left);
		return i;
	}
	public  void heapSort(int[] array) {
		createHeap(array);
		for(int i=0;i<array.length-1;i++) {
			swap(array,array.length-1-i,0);
			shiftDown(array,array.length-1-i,0);
		}
	}
	private static void createHeap(int[] array) {
		for (int i = (array.length - 1) / 2; i >= 0; i--) {
			shiftDown(array, array.length, i);
		}
	}
	public static void shiftDown(int[] array, int size, int index) {
		int left=2*index+1;
		while(left<size) {
			int right=left+1;
			int max=left;
			//存在条件下
			if(right<=size-1)
				max=array[left]>=array[right]?left:right;
			if(array[index]>=array[max]) {
				return;
			}
			//需要调整
			swap(array,index,max);
			index=max;
			left=2*index+1;
		}
	}
	public static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	public static void mergeSort(int[] array) {
		mergeSortInternal(array,0,array.length);
	}
	private static void mergeSortInternal(int[] array, int low, int high) {
		// TODO 自动生成的方法存根
		if(low>=high-1) return;
		int mid=(low+high)/2;
		mergeSortInternal(array,low,mid);
		mergeSortInternal(array,mid,high);
		merge(array,low,mid,high);
	}
	private static void merge(int[] array, int low, int mid, int high) {
		// TODO 自动生成的方法存根
		int[] extra=new int[high-low];
		int i=low,j=mid;
		int k=0;
		//核心代码
		while(i<mid&&j<high) {
			extra[k++]=array[i]<=array[j]?array[i++]:array[j++];
		}
		//剩余元素归位
		while(i<mid) {
			extra[k++]=array[i++];
		}
		while(j<high) {
			extra[k++]=array[j++];
		}
		//搬回原位置
		System.arraycopy(extra, 0, array, low, extra.length);
	}
}

package 实验课一;

import java.util.Arrays;
import java.util.Random;

public class a {
	public static void insertSort(double[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			double key = array[i + 1];
			int j;
			for (j = i; j >= 0 && key < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = key;
		}
	}
	public static void mergeSort(double[] array) {
	    mergeSortInternal(array, 0, array.length);
	}

	private static void mergeSortInternal(double[] array, int low, int high) {
	    if (low + 1 >= high) {
	    	return;
		}

		int mid = (low + high) / 2;
		// [low, mid)
		// [mid, high)
		mergeSortInternal(array, low, mid);
		mergeSortInternal(array, mid, high);
		merge(array, low, mid, high);
	}

	private static void merge(double[] array, int low, int mid, int high) {
		int length = high - low;
		double[] extra = new double[length];
		// [low, mid)
		// [mid, high)

		int iLeft = low;
		int iRight = mid;
		int iExtra = 0;

		while (iLeft < mid && iRight < high) {
			if (array[iLeft] <= array[iRight]) {
				extra[iExtra++] = array[iLeft++];
			} else {
				extra[iExtra++] = array[iRight++];
			}
		}

		while (iLeft < mid) {
			extra[iExtra++] = array[iLeft++];
		}

		while (iRight < high) {
			extra[iExtra++] = array[iRight++];
		}

		for (int i = 0; i < length; i++) {
			array[low + i] = extra[i];
		}
	}
	private static void insertSortWithGap(double[] array, int gap) {
		for (int i = 0; i < array.length - gap; i++) {
			double key = array[i + gap];
			int j;
			for (j = i; j >= 0 && key < array[j]; j -= gap) {
				array[j + gap] = array[j];
			}
			array[j + gap] = key;
		}
	}

	public static void shellSort(double[] array) {
	    int gap = array.length;
	    while (true) {
	        gap = gap / 3 + 1;
	        insertSortWithGap(array, gap);
	        if (gap == 1) {
	            return;
			}
		}
	}

	private static int[] buildSortedArray(int n) {
		int[] array = new int[n];
	    for (int i = 0; i < n; i++) {
	        array[i] = i;
		}

	    return array;
	}

	private static int[] buildReversedSortedArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = n - i;
		}

		return array;
	}

	private static double[] buildRandomArray(int n) {
		Random random = new Random(20190828);
		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
		    array[i] = random.nextDouble();
		}

		return array;
	}

	private static int[] buildEqualsArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = n;
		}

		return array;
	}

	public static void selectSort(double[] array) {
		// ÿ��ѡ������
	    for (int i = 0; i < array.length - 1; i++) {
			// ��������	[0, array.length - i)
	        // ��������	[array.lenngth - i, array.length)
            int max = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] >= array[max]) {
                    max = j;
				}
			}

            // ������������������������һ����
            swap(array, max, array.length - i - 1);
		}
	}

	private static void swap(double[] array, int i, int j) {
	    double t = array[i];
	    array[i] = array[j];
	    array[j] = t;
	}
	public static void quickSort(double[] array) {
		InnerquickSort(array,0,array.length-1);
	}
    public static void InnerquickSort(double[] array,int left,int right) {	
    if(left>right) return;
    int index=reviewpartition(array,left,right);
    InnerquickSort(array,left,index-1);
    InnerquickSort(array,index+1,right);
    }
    private static int reviewpartition(double[] array,int left,int right) {
    	//������׼ֵ
    	double pivot=array[left];
    	int p=left;
    	int q=right;
    	while(p<q) {
    		while(p<q&&array[q]>=pivot) {
    			q--;
    		}
    		while(p<q&&array[p]<=pivot) {
    			p++;
    		}
    		swap(array,p,q);
    	}
    	swap(array,p,left);
    		return p;
    }
    public static void heapSort(double[] array) {
    	//����һ����
    	createHeap(array);
    	//�����㷨���ѭ��-1
    	for(int i=0;i<array.length-1;i++) {
    		//�ҵ����ֵmax�����������ѣ��±�0��Ϊ���Ԫ��
    		swap(array,array.length-1-i,0);
    		heapify(array,array.length-i-1,0);
    	}
    }
    private static void createHeap(double[] array) {
    	// TODO �Զ����ɵķ������
    	//���һ�����ڵ㿪ʼ��������
    	int parent=(array.length-1-1)/2;
    	for(int i=parent;i>=0;i--) {
    		heapify(array,array.length,i);//���飬ʵ�ʳ��ȣ������±�λ��
    	}
    	
    }
	public static void bubbleSort(double[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	    	// ���������� [0, arrya.length - i)
			boolean sorted = true;
	        for (int j = 0; j < array.length - i - 1; j++) {
	            if (array[j] > array[j + 1]) {
	                swap(array, j, j + 1);
	                sorted = false;
				}
			}

	        if (sorted) {
	        	break;
			}
		}
	}
	private static void heapify(double[] array, int size, int index) {
    	if(size<=index) return;
    	while(true) {
    		int leftchild=2*index+1;
    		int rightchild=2*index+2;
    		if(leftchild>=size) return;
    		int max=leftchild;
    		if((rightchild<size)&&(array[leftchild]<array[rightchild]))
    			max=rightchild;
    		if(array[index]>=array[max]) {return;}
    	    	swap(array,index,max);
    	    	index=max;
    	    	}
    	}
	public static void main(String[] args) {
		System.out.println("***********��1������************");
		double[] array1;
		array1 = buildRandomArray(20);
		int count1=20;
		while(count1>0) {
        long begin = System.nanoTime();	// ����
        quickSort(array1);
		long end = System.nanoTime();	// ����
		System.out.println(end - begin);
		array1 = buildRandomArray(20);
		count1--;
		}
		System.out.println("***********��2������************");
		double[] array2;
		array2 = buildRandomArray(200);
		int count2=20;
		while(count2>0) {
        long begin = System.nanoTime();	// ����
        selectSort(array2);
		long end = System.nanoTime();	// ����
		System.out.println(end - begin);
		array2 = buildRandomArray(200);
		count2--;
		}
		System.out.println("***********��3������************");
		double[] array3;
		array3 = buildRandomArray(2000);
		int count3=20;
		while(count3>0) {
        long begin = System.nanoTime();	// ����
        selectSort(array3);
		long end = System.nanoTime();	// ����
		System.out.println(end - begin);
		array3 = buildRandomArray(2000);
		count3--;
		}
		System.out.println("***********��4������************");
		double[] array4;
		array4 = buildRandomArray(20000);
		int count4=20;
		while(count4>0) {
        long begin = System.nanoTime();	// ����
        shellSort(array4);
		long end = System.nanoTime();	// ����
		System.out.println(end - begin);
		array4 = buildRandomArray(20000);
		count4--;
		}
		System.out.println("***********��5������************");
		double[] array5;
		array5 = buildRandomArray(200000);
		int count5=20;
		while(count5>0) {
        long begin = System.nanoTime();	// ����
        //heapSort(array5);
		//insertSort(array5);
		Arrays.sort(array5);
        //quickSort(array5);
        //bubbleSort(array5);
        //mergeSort(array5);
        //quickSort(array5);
		long end = System.nanoTime();	// ����
		System.out.println(end - begin);
		array5 = buildRandomArray(200000);
		count5--;
		}
		//System.out.println(Arrays.toString(array));
	}
}
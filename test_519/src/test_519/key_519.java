package test_519;//�������ϰ��������ʱ��ͨ���ô�д����ĸ�����������o(T��To)

//import java.lang.reflect.Array;

public class key_519 {
public static int max(int[] array) {
	int max=Integer.MIN_VALUE;
	for(int i=0;i<array.length;i++) {
		if(max<array[i]) {
			max=array[i];
		}
	}
	return max;
}
public static int min(int[] array) {
	int min=Integer.MAX_VALUE;
	for(int i=0;i<array.length;i++) {
		if(min>array[i]) {
			min=array[i];
		}
	}
	return min;
}
public static int max1(int[] array) {
	int max=Integer.MIN_VALUE;
	for(int item:array) {
		if(item>max) {
			max=item;
		}
	}
	return max;
}
public static int indexOf(int[] array,int key) {
	for(int i=0;i<array.length;i++) {
		if(key==array[i]) {
			return i;
		}
}
	return 0;
}
public static double average(int[] scores) {
	double sum=0;
	for(int i=0;i<scores.length;i++) {
	sum+=scores[i];
}
	sum-=max(scores);
	sum-=min(scores);
	return sum/(scores.length-2);
}
/*public static int[] copyOf(int[] src,int newLength) {
	for (int i=0;i<src.length;i++){
	
	}
	return 0;
}*/
public static void main(String[] args) {
	int[] array= {1,2,3,18,19,26};
	int maxValue=max(array);
	System.out.println("���ֵ��"+maxValue);
	
	int index=indexOf(array,19);
	System.out.println("19���±���"+index);
	
	double averageScore=average(array);
	System.out.printf("ƽ������%.4f%n",averageScore);
}
}

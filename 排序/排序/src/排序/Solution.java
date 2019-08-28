package ����;

import java.util.Arrays;
//ʲô���������У��������У�
//�����������Ѿ��źõ����ݵļ��ϣ��������о��ǻ�δ�źã�����׼������ļ���
//ʲô�Ǽ����㷨
//����˼�����ÿ�α�����ѭ����,���ݹ�ģ���𽥼�С��
//����ѡ������ÿ����ѡһ�����ķ����������У��������м�С��
//��������������ÿһ��ȡһ��Ԫ�����Ѿ��źõ����н��бȽ�
//�����㷨���͵��㷨����
//ѡ��Ͳ�������
//�ڴ�������ʲô����
//���ѭ��-1���ڲ㲻��
public class Solution {
public static void insert(int[] array) {
	//�����㷨���ѭ������-1
	for(int i=0;i<array.length-1;i++) {
		//�������� [0,i]
		//�������� [i+1,length)
		int j;int key=array[i+1];//key������������Ԫ��
		//�Ӻ���ǰ����
		for(j=i;j>=0;j--) {
			if(array[j]<=key) break;
			//���
			array[j+1]=array[j];
		}
		//����ѭ��������Ȧ��ֵ
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
	//�����㷨���ѭ������-1
	for(int i=0;i<array.length-gap;i++) {
		//�������� [0,i]
		//�������� [i+1,length)
		int j;int key=array[i+gap];//key������������Ԫ��
		//�Ӻ���ǰ����
		for(j=i;j>=0;j-=gap) {
			if(array[j]<=key) break;
			//���
			array[j+gap]=array[j];
		}
		//����ѭ��������Ȧ��ֵ
		array[j+gap]=key;
	}
}
//ѡ���������ݲ����е����з�ʽ��
public static void chooseMax(int[] array) {
	//�����㷨���ѭ������-1
	for(int i=0;i<array.length-1;i++) {
		int max=0;//�����һ��Ԫ�����,max�±����0
		//������ʶ�������㷨����˻Ὣ����д��j<array.length-1-i
		//�������Ԫ�ؾͻᱻ���ӣ������������ѧϰ�����Ժ��Ӽ����㷨���ѭ������-1���Ż�
		for(int j=1;j<array.length-i;j++) {
			if(array[max]<array[j])
				max=j;
		}
		//����ѭ���ҵ����ֵmax����
		wrap(array,array.length-1-i,max);//Ŀ�����Ԫ�طŵ����
	}
}
public static void wrap(int[] array, int i, int k) {
	// TODO �Զ����ɵķ������
	int t;
	t=array[i];
	array[i]=array[k];
	array[k]=t;
}
public static void heapSort(int[] array) {
	//����һ����
	createHeap(array);
	//�����㷨���ѭ��-1
	for(int i=0;i<array.length-1;i++) {
		//�ҵ����ֵmax�����������ѣ��±�0��Ϊ���Ԫ��
		wrap(array,array.length-1-i,0);
		heapify(array,array.length-i-1,0);
	}
}
private static void heapify(int[] array, int size, int index) {
	// TODO �Զ����ɵķ������
	//���Ƿ���Ҷ�ӽڵ㣩�ж��Ƿ�Խ��
	//max��¼���Ƚ����Һ���˭��
	//max��index�Ƚ��Ƿ���Ҫ������������ѣ����array[index]<array[max]��Ҫ������������Ҫ��
	//Υ���±����
	if(size<=index) return;
	while(true) {
		int leftchild=2*index+1;
		int rightchild=2*index+2;
		if(leftchild>=size) return;//���Ӵ���
		int max=leftchild;
		if((rightchild<size)&&(array[leftchild]<array[rightchild]))
			max=rightchild;
	    //ע�����ﷵ��
		if(array[index]>=array[max]) {return;}
	    	wrap(array,index,max);
	    	index=max;
	    	}
	}
/*private static void createHeap(int[] array) {
	// TODO �Զ����ɵķ������
	//���һ�����ڵ㿪ʼ��������
	int parents=(array.length-1-1)/2;
	for(int i=parents;i>=0;i--) {
		heapify(array,i,0);
	}
	
}*/
private static void createHeap(int[] array) {
	// TODO �Զ����ɵķ������
	//���һ�����ڵ㿪ʼ��������
	int parent=(array.length-1-1)/2;
	for(int i=parent;i>=0;i--) {
		heapify(array,array.length,i);//���飬ʵ�ʳ��ȣ������±�λ��
	}
	
}
public static void main(String[] args) {
	int[] array1= {8,1,2,3,4,9,5,6,3};
	int[] array2= {9,8,7,6,5,4,3,2,1};
	int[] array3= {8,1,2,3,4,9,5,6,3};
	int[] array= {9,8,7,6,5,4,3,2,1};
	//��������
	insert(array1);
	//ѡ������ѡ�����
	chooseMax(array2);
	//ϣ������
	shell(array3);
	//������
	heapSort(array);
	System.out.println(Arrays.toString(array1));
	System.out.println(Arrays.toString(array2));
	System.out.println(Arrays.toString(array3));
	System.out.println(Arrays.toString(array));
}
}

package test_1117;

public class Solution {
	static int completeValue=9;
	public static void main(String[] args) {
	int[][] array= {{0,1,1,0},{0,1,4,0},{0,2,2,0}};
	printArrays(array);
	//�ҵ����ȼ��ߵ�ǰ����ʲô��
	//����Ҫ��ʱ�䲻��Ϊ0
    //�ҵ����ȼ��ߵ�
	int needTimeAll = 0;
	for(int i=0;i<array.length;i++) {
		needTimeAll+=array[i][1];
	}
	while(needTimeAll!=0) {
	//ȥ����Сֵ
	int maxValue=-10000;
	int maxIndex=-10;
	for(int i=0;i<array.length;i++) {	
		if(array[i][1]!=0) {
			//maxIndex����,���ȼ���ߵ��±�
			if(maxValue<array[i][2]) {
				maxValue=array[i][2];
				maxIndex=i;
			}
		}
	}
	//System.out.println((maxIndex+1)+"���ȼ����");
	//���ȼ����������Ҫ��ʱ�䲻Ϊ0�����ô˽�������
	//���ȼ�-1;��Ҫʱ��-1;
	if(maxIndex==-10) break;
	array[maxIndex][1]--;
	array[maxIndex][2]--;
	array[maxIndex][0]++;
	//������̿�ʼ���У���CPUTIME������0ʱ��CPUTIME+1
	//������������
	for(int i=0;i<array.length;i++) {	
			if(array[i][0]!=0) {
				//���δ��ɣ��ͼ�1
				if(array[i][3]!=completeValue) {
					array[i][0]++;
				}
			}
	}
	//���м�������CPUTIME���ص�ʱ��
	array[maxIndex][0]--;
	//ִ�к������Ҫʱ��Ϊ0�����ȼ���Ϊfinish

	if(array[maxIndex][1]==0) {
		System.out.println("finish"+(maxIndex+1)+"�Ž���");
		array[maxIndex][3]=completeValue;
	}
	needTimeAll--;
	printArrays(array);
	}
	}
	private static void printArrays(int[][] array) {
		// TODO �Զ����ɵķ������
		System.out.println("CPUTIME"+" NeedTime"+" Priority"+" complete(����9���������ֵ)");
		for(int[] i:array) {
			for(int j:i) {
			System.out.print(" "+j+"       ");
			}
			System.out.println();
		}
		System.out.println("__________________________________________");
	}
}

package test1025;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

//Ŀ�깦�ܣ��������10000���������������һ����������һ��������10000�����ҵ���������������������ҵ������ӡ��û�ҵ���
public class Solution {
	public static void main(String[] args) {
		//���������ģ
		int scale=200000;
		double[] array=new double[scale];
		//�������10000����������������
		//ʹ��BigDecimal��������nλС��������n=2��
		for(int i=0;i<scale;i++) {
			//0.00-99.99 generate()
	        double a=Math.random()*100;
	        BigDecimal decimal=new BigDecimal(a);
	        double d=decimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
			array[i]=d;	
			}
		double test=Math.random()*100;
		BigDecimal decimal=new BigDecimal(test);
		double testNumber=decimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		boolean flag=false;
	//Arrays.sort(array);
		long numberCount=System.nanoTime();
		for(int i=0;i<scale;i++) {
			if(array[i]==testNumber) {
				System.out.println("˳���ҵ����±�λ��Ϊ"+i);
				flag=true;
			}
		}
		if(!flag) {
			System.out.println("û�ҵ�");
		}
		long numberCountEnd=System.nanoTime();
		System.out.println(numberCountEnd-numberCount+"����");
		
		Search l=new Search();
		System.out.println("*******************�Ѿ�����*********************");
		Arrays.sort(array);
		long numberBinary=System.nanoTime();
		List<Integer> position = l.commonBinarySearch(array, testNumber);
		long numberBinaryEnd=System.nanoTime();
		System.out.println(numberBinaryEnd-numberBinary+"����");
		position.sort(null);
		for(int i:position) {
			System.out.println("���ֲ����ҵ����±�λ��Ϊ"+i);
		}
		
	}
	}


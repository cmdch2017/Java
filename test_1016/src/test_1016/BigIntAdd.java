package test_1016;

import java.util.Arrays;
import java.util.Scanner;

public class BigIntAdd {
	private int[] array;//����һ������
    //���������ӵĺ���
	public static String bigAdd(BigIntAdd firstNum, BigIntAdd secondNum) {
		System.out.println(firstNum.toString());
		System.out.println(secondNum.toString());
		String result = "";
		boolean flag = false;//�ж������Ƿ�Խ��ı�־
		int onePlus=0;//������λ
		//Ŀ��ʵ��Ч����arrayOneλ�����ڵ���arrayTwo��λ��
		int[] arrayOne;
		int[] arrayTwo;
		int[] arrayThree = null;
		//�ѽϳ����ַ����ŵ�arrayOne�����У���ΪҪ�Ѽ������ŵ�arrayOne������
		int length=firstNum.instance().length - secondNum.instance().length;
		if (length>=0) {
			arrayOne = firstNum.instance();
			arrayTwo = secondNum.instance();
		 } else {
			arrayOne = secondNum.instance();
			arrayTwo = firstNum.instance();
		 }
		//������λ���С������secondTwo
		for (int i = 0; i < arrayTwo.length; i++) {
			if (arrayOne[i] + arrayTwo[i]+onePlus < 10) {//����Ҫ��λʱ
				arrayOne[i] +=arrayTwo[i]+onePlus;
				onePlus=0;
			} else if (arrayOne[i] + arrayTwo[i]+onePlus >= 10) {//��Ҫ��λʱ
				arrayOne[i] = arrayOne[i] + arrayTwo[i]+onePlus - 10;
				onePlus=0;
				if ((i + 1) < arrayOne.length) {
					//arrayOne[i + 1] = arrayOne[i + 1] + 1;//��һλ��ֵ��1
						onePlus=1;
				} else {
					//��arrayOne�ĳ��Ȳ���ʱҪ���临�Ƶ�arrayThree��
					flag = true;
					arrayThree = new int[arrayOne.length + 1];
					System.arraycopy(arrayOne, 0, arrayThree, 0,arrayOne.length);
					arrayThree[arrayOne.length] = 1;//��arrayThree���λ��ֵ1���ȼ��ڽ�λ��1
				}
			}
		}		
		//������arrayThree�е�Ԫ��ȫ����ƴ��Ϊ�ַ���
		if (flag) {
			for (int i : arrayThree) {
				result += i;
			}
		} else {
			for (int i : arrayOne) {
				result += i;
			}
		}
		//�ѽ����ת����
		return new StringBuffer(result).reverse().toString();
	}
	    @Override
	public String toString() {
		return "BigIntAdd [array=" + Arrays.toString(array) + "]";
	}
		//��ʼ�����鷽��
		private int[] instance() {
			return array;
		}
	   //��ʼ�����췽��
		public BigIntAdd(String num) {
			StringBuilder sb = new StringBuilder(num);
			String string = sb.reverse().toString();//ʵ���ַ�����ת�����ڼ���
			array = new int[string.length()];
			//���ַ���ת��Ϊ����
			for (int i = 0; i < string.length(); i++) {
				array[i] = Integer.valueOf(string.substring(i, i + 1));
			}
		}
		public static  void  main(String [] args){
			System.out.println("*********************************");
			System.out.println("���԰���һ");
			System.out.println("*********************************");
			Scanner sc=new Scanner(System.in);
			String a=sc.nextLine();
			String b=sc.nextLine();
			String re=BigIntAdd.bigAdd(new BigIntAdd(a), new BigIntAdd(b));
			System.out.println("return value="+re);
			try {
				System.out.println("����Ԥ����");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			System.out.println("*********************************");
			System.out.println("���԰�����");
			System.out.println("*********************************");
			String result=BigIntAdd.bigAdd(new BigIntAdd("1999999999999"), new BigIntAdd("1"));
			System.out.println(result);
		}

		
		
}

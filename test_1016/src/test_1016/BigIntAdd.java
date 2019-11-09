package test_1016;

import java.util.Arrays;
import java.util.Scanner;

public class BigIntAdd {
	private int[] array;//声明一个数组
    //计算大数相加的函数
	public static String bigAdd(BigIntAdd firstNum, BigIntAdd secondNum) {
		System.out.println(firstNum.toString());
		System.out.println(secondNum.toString());
		String result = "";
		boolean flag = false;//判断数组是否越界的标志
		int onePlus=0;//连续进位
		//目标实现效果：arrayOne位数大于等于arrayTwo的位数
		int[] arrayOne;
		int[] arrayTwo;
		int[] arrayThree = null;
		//把较长的字符串放到arrayOne数组中，因为要把计算结果放到arrayOne数组中
		int length=firstNum.instance().length - secondNum.instance().length;
		if (length>=0) {
			arrayOne = firstNum.instance();
			arrayTwo = secondNum.instance();
		 } else {
			arrayOne = secondNum.instance();
			arrayTwo = firstNum.instance();
		 }
		//遍历数位相对小的数组secondTwo
		for (int i = 0; i < arrayTwo.length; i++) {
			if (arrayOne[i] + arrayTwo[i]+onePlus < 10) {//不需要进位时
				arrayOne[i] +=arrayTwo[i]+onePlus;
				onePlus=0;
			} else if (arrayOne[i] + arrayTwo[i]+onePlus >= 10) {//需要进位时
				arrayOne[i] = arrayOne[i] + arrayTwo[i]+onePlus - 10;
				onePlus=0;
				if ((i + 1) < arrayOne.length) {
					//arrayOne[i + 1] = arrayOne[i + 1] + 1;//下一位的值加1
						onePlus=1;
				} else {
					//当arrayOne的长度不够时要把其复制到arrayThree中
					flag = true;
					arrayThree = new int[arrayOne.length + 1];
					System.arraycopy(arrayOne, 0, arrayThree, 0,arrayOne.length);
					arrayThree[arrayOne.length] = 1;//把arrayThree最高位赋值1，等价于进位的1
				}
			}
		}		
		//把数组arrayThree中的元素全部的拼接为字符串
		if (flag) {
			for (int i : arrayThree) {
				result += i;
			}
		} else {
			for (int i : arrayOne) {
				result += i;
			}
		}
		//把结果反转返回
		return new StringBuffer(result).reverse().toString();
	}
	    @Override
	public String toString() {
		return "BigIntAdd [array=" + Arrays.toString(array) + "]";
	}
		//初始化数组方法
		private int[] instance() {
			return array;
		}
	   //初始化构造方法
		public BigIntAdd(String num) {
			StringBuilder sb = new StringBuilder(num);
			String string = sb.reverse().toString();//实现字符串反转，便于计算
			array = new int[string.length()];
			//把字符串转化为数组
			for (int i = 0; i < string.length(); i++) {
				array[i] = Integer.valueOf(string.substring(i, i + 1));
			}
		}
		public static  void  main(String [] args){
			System.out.println("*********************************");
			System.out.println("测试案例一");
			System.out.println("*********************************");
			Scanner sc=new Scanner(System.in);
			String a=sc.nextLine();
			String b=sc.nextLine();
			String re=BigIntAdd.bigAdd(new BigIntAdd(a), new BigIntAdd(b));
			System.out.println("return value="+re);
			try {
				System.out.println("正在预设中");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("*********************************");
			System.out.println("测试案例二");
			System.out.println("*********************************");
			String result=BigIntAdd.bigAdd(new BigIntAdd("1999999999999"), new BigIntAdd("1"));
			System.out.println(result);
		}

		
		
}

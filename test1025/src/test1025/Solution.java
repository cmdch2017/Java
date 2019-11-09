package test1025;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

//目标功能，随机生成10000个数，再随机生成一个数，若这一个数能在10000个数找到，返回这个数，若不能找到，则打印“没找到”
public class Solution {
	public static void main(String[] args) {
		//设置数组规模
		int scale=200000;
		double[] array=new double[scale];
		//随机生成10000个数，保存入数组
		//使用BigDecimal做到保留n位小数，这里n=2；
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
				System.out.println("顺序找到了下标位置为"+i);
				flag=true;
			}
		}
		if(!flag) {
			System.out.println("没找到");
		}
		long numberCountEnd=System.nanoTime();
		System.out.println(numberCountEnd-numberCount+"纳秒");
		
		Search l=new Search();
		System.out.println("*******************已经排序*********************");
		Arrays.sort(array);
		long numberBinary=System.nanoTime();
		List<Integer> position = l.commonBinarySearch(array, testNumber);
		long numberBinaryEnd=System.nanoTime();
		System.out.println(numberBinaryEnd-numberBinary+"纳秒");
		position.sort(null);
		for(int i:position) {
			System.out.println("二分查找找到了下标位置为"+i);
		}
		
	}
	}


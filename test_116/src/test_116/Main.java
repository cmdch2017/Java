package test_116;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String A=sc.nextLine();
		String B=sc.nextLine();
		//String A="aba";
		//String B="b";
		StringBuilder a=new StringBuilder(A);
		StringBuilder b=new StringBuilder(B);
		int count=0;
		for(int i=0;i<a.length()+1;i++) {
		StringBuilder c=a.insert(i, b);
		if(backtrace2(c.toString())) {
		count++;
		}
        a.delete(i, i+b.length());
		}
		System.out.println(count);
}
	//这两个方法实现目的和思路基本一样，只是实现路径不一样
	//StringBuilder自身reverse()方法
	private static boolean backtrace2(String string) {
		StringBuilder c=new StringBuilder(string);
		return (c.reverse().toString().equals(string));
	}
	//常规转化思路
	private static boolean backtrace(String string) {
		// TODO 自动生成的方法存根
		char[] array=string.toCharArray();
		StringBuilder c=new StringBuilder();
		for(int i=array.length-1;i>=0;i--) {
			c.append(array[i]);
		}
		return (c.toString()).equals(string);
	}
}

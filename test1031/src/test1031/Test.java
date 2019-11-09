package test1031;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static List <String> recordSucceed=new ArrayList<>();
	public static void main(String[] args) {
		selectISBN();
		UpdateReview();
		for(String i:recordSucceed) {
			System.out.println("日志记录："+i);
		}
	}

	private static void UpdateReview() {
		// TODO 自动生成的方法存根
		System.out.println("自己输入更改命令输入9,默认修改输入数字0-8");
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		if(p==9) {
			System.out.println("请输入查询指令");
			Scanner sq=new Scanner(System.in);
			String sql=sq.nextLine();
			boolean a=UpdateReview.Update(sql);
			if(a) {
				recordSucceed.add(sql);
			}
		}
		else {
		UpdateReview.Update("UPDATE booklist set author='a1'  where pages<100;");
		recordSucceed.add("UPDATE booklist set author='a1'  where pages<100");
		}
		}

	private static void selectISBN() {
		// TODO 自动生成的方法存根
		System.out.println("请输入ISBN");
		//978-7-302-32697-2
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		SelectReview.Select(str);
		recordSucceed.add(str);
	}
}

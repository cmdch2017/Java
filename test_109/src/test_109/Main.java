package test_109;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		welcome();
		User currentUser = User.login();
		boolean isQuit;
		do {
			currentUser.menu();
			isQuit=currentUser.input();
		}while(!isQuit);
		System.out.println("welcome come back");
	}

	private static void welcome() {
		// TODO 自动生成的方法存根
		System.out.println("---欢迎进入Byte图书管理系统---");
		System.out.println("进入你所需要的语言");
		Scanner sc=new Scanner(System.in);
		String language=sc.nextLine();
		if(language.equals("英语")) {
			System.out.println("尚未开通，强制跳入中文版");
			}
			else {
				System.out.println("语言切换成功");
			}
	}
}

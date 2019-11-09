package test_109;

import java.util.Scanner;

import action.Action;

public class Teacher extends User {
	public Teacher(String id, String name) {
		super(id, name);
		// TODO 自动生成的构造函数存根
	}
	public void putBook() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入ISBN");
		String ISBN=scanner.nextLine();
		System.out.println("请输入标题");
		String title=scanner.nextLine();
		System.out.println("请输入作者");
		String author=scanner.nextLine();
		System.out.println("请输入价格");
		double price=scanner.nextDouble();
		System.out.println("请输入数目");
		int count=scanner.nextInt();
		Book book=Action.putBook(ISBN,title,author,price,count);
		System.out.println("上架成功");
	}
	@Override
	public void menu() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public boolean input() {
		// TODO 自动生成的方法存根
		return false;
	}
}

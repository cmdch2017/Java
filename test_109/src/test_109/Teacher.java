package test_109;

import java.util.Scanner;

import action.Action;

public class Teacher extends User {
	public Teacher(String id, String name) {
		super(id, name);
		// TODO �Զ����ɵĹ��캯�����
	}
	public void putBook() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������ISBN");
		String ISBN=scanner.nextLine();
		System.out.println("���������");
		String title=scanner.nextLine();
		System.out.println("����������");
		String author=scanner.nextLine();
		System.out.println("������۸�");
		double price=scanner.nextDouble();
		System.out.println("��������Ŀ");
		int count=scanner.nextInt();
		Book book=Action.putBook(ISBN,title,author,price,count);
		System.out.println("�ϼܳɹ�");
	}
	@Override
	public void menu() {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public boolean input() {
		// TODO �Զ����ɵķ������
		return false;
	}
}

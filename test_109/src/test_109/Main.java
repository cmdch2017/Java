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
		// TODO �Զ����ɵķ������
		System.out.println("---��ӭ����Byteͼ�����ϵͳ---");
		System.out.println("����������Ҫ������");
		Scanner sc=new Scanner(System.in);
		String language=sc.nextLine();
		if(language.equals("Ӣ��")) {
			System.out.println("��δ��ͨ��ǿ���������İ�");
			}
			else {
				System.out.println("�����л��ɹ�");
			}
	}
}

package ͨѶ¼;

import java.util.Scanner;


public class User {
	  private String id;
	    private String name;

	    public User(String id, String name) {
	        this.id = id;
	        this.name = name;
	    }
	    private static User currentUser = null;
	public static User login() throws InterruptedException {
		// TODO �Զ����ɵķ������
		System.out.println("��ӭ����ͨѶ¼ϵͳ���������������Ϣ");
		System.out.println("���������ID");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		if(currentUser.equals("01")) {
		if(checked(a))
		System.out.println("����ɹ�");
		}
		else {
			System.out.println("���ڵ�����");
		}
        return currentUser;
	}

	private static boolean checked(String a) throws InterruptedException {
		// TODO �Զ����ɵķ������
		System.out.println("�������У����Ժ�");
		Thread.sleep(1000);
		return true;
	}

	public void menu() {
		// TODO �Զ����ɵķ������
		
	}

	public boolean input() {
		// TODO �Զ����ɵķ������
		return false;
	}

}

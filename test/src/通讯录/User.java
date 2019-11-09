package 通讯录;

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
		// TODO 自动生成的方法存根
		System.out.println("欢迎受用通讯录系统，请你输入个人信息");
		System.out.println("请输入你的ID");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		if(currentUser.equals("01")) {
		if(checked(a))
		System.out.println("进入成功");
		}
		else {
			System.out.println("正在调试中");
		}
        return currentUser;
	}

	private static boolean checked(String a) throws InterruptedException {
		// TODO 自动生成的方法存根
		System.out.println("身份审核中，请稍后");
		Thread.sleep(1000);
		return true;
	}

	public void menu() {
		// TODO 自动生成的方法存根
		
	}

	public boolean input() {
		// TODO 自动生成的方法存根
		return false;
	}

}

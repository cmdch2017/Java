package CallName;
import java.util.Random;
import java.util.Scanner;
public class CallName {
//存储全班同学姓名，创建一个储存多个同学姓名的容器（数组）
	//键盘输入并存储入容器
	public static void addStudentName(String[] students) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<students.length;i++) {
			System.out.println("存储第"+(i+1)+"个姓名：");
			students[i]=sc.next();
		}
		sc.close();
	}
	public static void printStudentName(String[] students) {
		for(int i=0;i<students.length;i++) {
			String name=students[i];
			System.out.println("第"+(i+1)+"个学生姓名："+name);
		}
	}
	public static <unsigned> String randomStudentName (String[] students) {
		int index=new Random().nextInt(students.length);//根据实际长度获取随机索引
		String name=students[index];//随机索引从数组中获得姓名
		return name;
	}
	public static void main(String[] args) {
		System.out.println("欢迎使用随机点名系统");
		System.out.println("输入班级人数");
		Scanner sc=new Scanner(System.in);
				int number=sc.nextInt();
	String[] students=new String[number];
	//存储全班同学姓名
	addStudentName(students);
	printStudentName(students);
	String randomName=randomStudentName(students);
	System.out.println("被点到名的同学是："+randomName);
	sc.close();
	}
}

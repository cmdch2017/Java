package CallName;
import java.util.Random;
import java.util.Scanner;
public class CallName {
//�洢ȫ��ͬѧ����������һ��������ͬѧ���������������飩
	//�������벢�洢������
	public static void addStudentName(String[] students) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<students.length;i++) {
			System.out.println("�洢��"+(i+1)+"��������");
			students[i]=sc.next();
		}
		sc.close();
	}
	public static void printStudentName(String[] students) {
		for(int i=0;i<students.length;i++) {
			String name=students[i];
			System.out.println("��"+(i+1)+"��ѧ��������"+name);
		}
	}
	public static <unsigned> String randomStudentName (String[] students) {
		int index=new Random().nextInt(students.length);//����ʵ�ʳ��Ȼ�ȡ�������
		String name=students[index];//��������������л������
		return name;
	}
	public static void main(String[] args) {
		System.out.println("��ӭʹ���������ϵͳ");
		System.out.println("����༶����");
		Scanner sc=new Scanner(System.in);
				int number=sc.nextInt();
	String[] students=new String[number];
	//�洢ȫ��ͬѧ����
	addStudentName(students);
	printStudentName(students);
	String randomName=randomStudentName(students);
	System.out.println("���㵽����ͬѧ�ǣ�"+randomName);
	sc.close();
	}
}

package GuessNumber;
import java.util.Random;
import java.util.Scanner;
//���ȳ����̨ҪԤ������0-9���������
//����������ķ�������ʹ��public int nextInt ��int n��
public class GuessNumber {
public static void main(String[] args) {
	int randomNumber =new Random().nextInt(10);
	System.out.println("������Ѿ�����");
	System.out.println("����µ�����");
	Scanner sc=new Scanner (System.in);
	int enterNumber =sc.nextInt();
	while(enterNumber!=randomNumber) {
		if(enterNumber>randomNumber) 
			System.out.println("����");
			else {
				System.out.println("С��");
			}
		System.out.println("����µ�����");
		enterNumber =sc.nextInt();
		}
	System.out.println("�¶���");	
	}
}

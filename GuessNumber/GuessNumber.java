package GuessNumber;
import java.util.Random;
import java.util.Scanner;
//首先程序后台要预先生成0-9的随机数，
//生成随机数的方法可以使用public int nextInt （int n）
public class GuessNumber {
public static void main(String[] args) {
	int randomNumber =new Random().nextInt(10);
	System.out.println("随机数已经生成");
	System.out.println("输入猜的数字");
	Scanner sc=new Scanner (System.in);
	int enterNumber =sc.nextInt();
	while(enterNumber!=randomNumber) {
		if(enterNumber>randomNumber) 
			System.out.println("大了");
			else {
				System.out.println("小了");
			}
		System.out.println("输入猜的数字");
		enterNumber =sc.nextInt();
		}
	System.out.println("猜对了");	
	}
}

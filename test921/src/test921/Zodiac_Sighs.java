package test921;

import java.util.Scanner;

public class Zodiac_Sighs {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		if(sc.hasNextInt()) {
			//12*1000保证公元前年份
			//+8作为公元零年是猴年的调整
			switch((sc.nextInt()+8+12*1000)%12) {
			case 0:System.out.println("🐀");break;
			case 1:System.out.println("🐂");break;
			case 2:System.out.println("🐅");break;
			case 3:System.out.println("🐇");break;
			case 4:System.out.println("🐉");break;
			case 5:System.out.println("🐍");break;
			case 6:System.out.println("🐎");break;
			case 7:System.out.println("🐏");break;
			case 8:System.out.println("🐒");break;
			case 9:System.out.println("🐓");break;
			case 10:System.out.println("🐶");break;
			case 11:System.out.println("🐖");break;
			}
		};
	}
}

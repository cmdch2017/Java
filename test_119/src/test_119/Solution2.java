package test_119;
import java.util.Scanner;
public class Solution2 {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String a=sc.nextLine();
	String b=sc.nextLine();
	int count=0;
	char[] array=a.toCharArray();//j
	char[] delete=b.toCharArray();//i
	int length=array.length;
	for(int i=0;i<delete.length;i++) {
		for(int j=0;j<length;j++) {
			if(delete[i]==array[j]) {
				move(array,j);
				count++;
				//break;
			}
		}
	}
	String ret=String.copyValueOf(array);
	String key=ret.substring(0, array.length-count);
	System.out.println(key.toString());
}

	public static void move(char[] array, int i) {
		// TODO 自动生成的方法存根
		if(i==array.length-1) {
			array[i]=0;
			return;
		}
		for(int index=i;index<array.length-1;index++) {
			array[index]=array[index+1];
			array[index+1]=0;
		}
	}
}


package test117;
import java.util.Scanner;
public class Main2{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
		char[] array=s1.toCharArray();
		int maxIndex=0;
		int maxCount=0;
		int count=0;
		for(int i=0;i<array.length;i++) {	
			if(array[i]<'0'||array[i]>'9') {
				count=0;
			}
			else {
				count++;
				if(maxCount<count) {
					maxCount=count;
					maxIndex=i;
				}
			}
		}
		//System.out.println(array[maxIndex]);
		String s2=s1.substring(maxIndex-maxCount+1, maxIndex+1);
		System.out.println(s2.toString());
	}
}

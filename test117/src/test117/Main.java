package test117;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	List<Integer> list=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	int a=sc.nextInt();
	while(a!=0) {
	boolean zeroFlag=((a%3)==0);//divided
	int sum=0;
	boolean special_1=(a==1);
	for(int i=a/3;i>0;i/=3) {
		sum+=i;
	}
	if(zeroFlag)
		list.add(sum);
	else {
		if(!special_1)
			list.add(sum+1);
		else
			list.add(0);
	}
	a=sc.nextInt();
	}
	sc.close();
	for(int i:list) {
		System.out.println(i);
	}
	}
}

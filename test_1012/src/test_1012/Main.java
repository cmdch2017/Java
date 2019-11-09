package test_1012;

import java.util.Scanner;

public class Main {
	static int fib(int n) {
		if((n==2)||(n==1)) {
			return 0;
		}
		int f1 = 0;
		int f2 = 1;
		int sum = 0;
		for (int i = 3; i <= n; i++)
		{
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		return sum;
	}
	// 0 1 1 2 3 5 8 13   21 34
	//4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int ret=0,i=0;
        while(true) {
        	ret=fib(i);
        	if(ret>=key)
        		break;
         i++;
        }
        int a1=fib(i-1);
        int a2=fib(i);
        if(key-a1<=a2-key) {
        	System.out.println(key-a1);
        }
        else {
        	System.out.println(a2-key);
        }

    }
}
package test_1018;

public class Solution_4 {
	public static int fun(int n) {
		int a=1;
		for(int i=1;i<=n;i++) {
			a*=i;
		}
		return a;
	}
	public static void main(String[] args) {
		int value;
		int sum=0;
		int ret=-1;
		for(int i=1;i<=10;i++) {
		 value=fun(i);
		 sum+=value;
		 if(sum>=10000) {
			 ret=i-1;
			 break;
		 }
		}
		System.out.println(ret);
	}
}

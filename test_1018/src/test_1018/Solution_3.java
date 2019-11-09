package test_1018;

public class Solution_3 {
	public static void main(String[] args) {
		for(int i=6;i<=1000;i++) {
			int sum=0;
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					sum+=j;
				}
			}
			if(sum==i) {
			System.out.println(i+" ");
			}
		}
	}
}

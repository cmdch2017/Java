package test_1018;

public class Solution_2 {
	public static void main(String[] args) {
	for(int i=2;i<1000;i++) {
		int flag=0;
		for(int j=2;j<i;j++) {
			if(i%j==0) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
		System.out.println(i+" ");	
		}
	}
	
	}
}

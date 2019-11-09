package test_1018;

public class Solution_5 {
	public static int threeMul(int n) {
		return n*n*n;
	}
	public static void main(String[] args) {
		for(int i=100;i<1000;i++) {
			int hundred=i/100;
			int ten=i/10%10;
			int one=i%10;
			if(threeMul(hundred)+threeMul(ten)+threeMul(one)==i) {
				System.out.println(i);
			}
		}
	}
}

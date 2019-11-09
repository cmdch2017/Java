package test_1023;

public class Demo14 {
	private int count;
	public static void main(String[] args) {
		
	}
	public  int getCount() {
		return count;
	}
	public int factorial(int n) {
		int result=1;
		for(int i=1;i<=n;i++) {
			result*=i;
		}
		return result;
	}
}

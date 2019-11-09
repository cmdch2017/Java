package test_1023;

public class Demo19 {
//i+j is :5
	//k is 2
	//j is 0
	static int i=0;
	static int j=0;
	public static void main(String[] args) {
		int i=2;
		int k=3;
		{
			int j=3;
			System.out.println(i+j);
		}
		k=i+j;
		System.out.println(k+" "+j);
	}
}

package test_1023;
class A1{
	static int g(int n) {
		return n*n;
	}
}
class B extends A1{
	static int g(int n) {
		int m=A1.g(n);
		return m+n;
	}
}
public class Demo21 {
	public static void main(String[] args) {
	B b=new B();
	System.out.println(b.g(3));
	}
}
// 98
// 12
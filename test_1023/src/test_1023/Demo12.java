package test_1023;
class A{
	String s;
	A(String s){
		this.s=s;
	}
	public void print() {
		System.out.println(s);
	}
}
public class Demo12 {
	public static void main(String[] args) {
		//没有无参的构造方法
		A a=new A("b");
		a.print();
	}
}

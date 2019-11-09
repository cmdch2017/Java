package test_1023;

public class Demo15 {
	//两个都不能，不能再静态方法中调用成员方法和成员变量
	//不能在成员方法中调用静态方法或引用静态变量
	public static void main(String[] args) {
		//不能对类型 Demo15 中的非静态方法 method1（）进行静态引用
		method1();
	}
	public static void method1() {
		method2();
	}
	public void method3() {
		
	}
	public static void method2() {
		//不能对非静态字段 c 进行静态引用
		System.out.println(c.getRadius());
		//构造实例，调用普通方法
		Demo15 l=new Demo15();
		l.method3();
	}
	static Circle c=new Circle();
}

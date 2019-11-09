package test_816_1;
class Parent{
}
public class Solution extends Parent {
Solution(){
	System.out.println();
}
Solution(int val){
	this();
	System.out.println();
}
int a=initA();
{
	System.out.println();
}
	public static void main(String[] args) {
		//56342
		//354612
	}
	private int initA() {
		// TODO 自动生成的方法存根
		return 0;
	}
}
//abstact关键字
//1.修饰类，该类是抽象类，无法被实例化的类，等着被继承
//2.修饰方法，该方法是抽象方法，没有被实现的方法
//abstract class A{} new A();
//abstract void method();
//包含抽象方法的一定的抽象类
//final关键字有什么作用
//1.修饰变量，该变量的值只能被初始化一次，无法再被修改
//2.修饰类，该类无法被继承
//3.修饰方法，该方法无法被覆写

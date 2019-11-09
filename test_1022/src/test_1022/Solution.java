
package test_1022;

class Base{
	public Base() {
		System.out.println("Base构造");
	}

	public void method() {

		System.out.println("Base");

	}

}

class Son extends Base{

	public Son() {
		System.out.println("son构造");
	}
 

	public void method() {

		System.out.println("son");

	}

	public static void a(){

		System.out.println("a");

	}

}

public class Solution {

	public static void main(String[] args) {
		
		Base base=new Son();
		
	}

}

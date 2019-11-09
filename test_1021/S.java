
package test_1021;

class Base{

	public void method() {

		System.out.println("Base");

	}

}

class Son extends Base{

 

	public void method() {

		System.out.println("son");

	}

	public static void a(){

		System.out.println("a");

	}

	public void methodB() {

		System.out.println("Son B");

	}

}

public class Solution {

	public static void main(String[] args) {

		Base base=new Son();

		base.method();

		((Son) base).methodB();

		//必须强制类型转换，base这个实例是对于Base这个类的类型，Base里只有method（）

		//说明不能直接调用methodB();

		//而且由于new 的对象是Son对象的引用,调用method方法只能是输出Son的method()

	}

}

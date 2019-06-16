package test617;
//子类重写父类后，子类对象无法访问父类被重写的方法
//super 关键字解决
class Animal{
	String name="动物";
	void shout() {
		System.out.println("动物发出叫声");
	}
}
class Dog extends Animal{
	String name="犬类";
//	void shout(){
//		super.shout();//调用父类的成员方法
//	}
	void printName() {
		System.out.println("name="+super.name);//访问父亲的成员变量
	}
}
public class Solution {
public static void main(String[] args) {
	Dog dog=new Dog();
	dog.shout();
	dog.printName();
}
}

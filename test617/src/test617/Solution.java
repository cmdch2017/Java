package test617;
//������д�������������޷����ʸ��౻��д�ķ���
//super �ؼ��ֽ��
class Animal{
	String name="����";
	void shout() {
		System.out.println("���﷢������");
	}
}
class Dog extends Animal{
	String name="Ȯ��";
//	void shout(){
//		super.shout();//���ø���ĳ�Ա����
//	}
	void printName() {
		System.out.println("name="+super.name);//���ʸ��׵ĳ�Ա����
	}
}
public class Solution {
public static void main(String[] args) {
	Dog dog=new Dog();
	dog.shout();
	dog.printName();
}
}

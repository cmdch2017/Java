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
		// TODO �Զ����ɵķ������
		return 0;
	}
}
//abstact�ؼ���
//1.�����࣬�����ǳ����࣬�޷���ʵ�������࣬���ű��̳�
//2.���η������÷����ǳ��󷽷���û�б�ʵ�ֵķ���
//abstract class A{} new A();
//abstract void method();
//�������󷽷���һ���ĳ�����
//final�ؼ�����ʲô����
//1.���α������ñ�����ֵֻ�ܱ���ʼ��һ�Σ��޷��ٱ��޸�
//2.�����࣬�����޷����̳�
//3.���η������÷����޷�����д

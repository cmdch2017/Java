package test_1023;

public class Foo{
	int i;
	static String s;
	void imethod(){
	}
	static void smethod(){ 
		
	}
	public static void main(String args[ ]){
	    Foo f=new Foo();
	    System.out.println(f.i);
	    System.out.println(f.s);
	    f.imethod();
	    f.smethod();
	    //���ܶԷǾ�̬�ֶ� Foo.i ���о�̬����
	    //System.out.println(Foo.i);
	   
	    System.out.println(Foo.s);
	    //���ܶ����� Foo �еķǾ�̬���� imethod�������о�̬����
	    //Foo.imethod();
	    Foo.smethod();

	}
}

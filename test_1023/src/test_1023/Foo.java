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
	    //不能对非静态字段 Foo.i 进行静态引用
	    //System.out.println(Foo.i);
	   
	    System.out.println(Foo.s);
	    //不能对类型 Foo 中的非静态方法 imethod（）进行静态引用
	    //Foo.imethod();
	    Foo.smethod();

	}
}

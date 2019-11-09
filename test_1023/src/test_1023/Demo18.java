package test_1023;
class T{
	static int i=0;
	int j=0;
	T(){
		i++;
		j=i;
	}
}
public class Demo18 {
	public static void main(String[] args) {
		T t1=new T();
		System.out.println(t1.i+" "+t1.j);
		T t2=new T();
		T t3=new T();
		System.out.println(t1.i+" "+t1.j);
	}
//1.a[0]=1 a[1]=2
//2.a[0]=2 a[1]=1
	//3.a[0]=2 a[1]=1
//4. 2 1
//	 2 2

	private static void swap(int n1, int n2) {
		// TODO 自动生成的方法存根
		int temp=n1;
		n1=n2;
		n2=temp;
	}
}

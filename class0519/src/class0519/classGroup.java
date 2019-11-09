package class0519;
class Group{
	//属性
	String name;//名称
	int num;//人数

	//方法
	//构造方法
Group (String n,int m){
	name=n;
	num=m;
}
Group(String n){//重载时，String n表示若传入参数
	//只传入一个string，则执行此函数
	name=n;
}
void print(String welcome) {
	System.out.printf("%s %s 的 %d 位同学们%n",
			welcome,//形参
			name,//属性
			num//属性
			);
	}
}
class B {
	int sum;
	B(int a,int b,int c){
		System.out.println(a+b+c);
		sum=a+b+c;
	}

void print() {
	System.out.println(sum);}
}

public class classGroup{
public static void main(String[] args) {
	B b=new B(1,2,3);
	b.print();
	Group group=new Group("java10班",50);
	group.print("欢迎来到比特");
}
}

package a;
class Node {
	int val;
	Node next;
   public Node(int val){
		this.val=val;
	}
}
public class solution {
public Node reverse(Node head) {
Node pre=null;
Node next=null;
while(head!=null) {
  next=head.next;
  head.next=pre;
  pre=head;
  head=next;
}
return pre;
}
public void display2(Node head) {
	for(Node cur=head;cur!=null;cur=cur.next) {
	System.out.println(cur.val);
	}
}
public void display(Node head) {
	Node cur=head;
	while(cur!=null) {
		System.out.print(cur.val+" ");
		cur=cur.next;
	}
	System.out.println("");
}
public static void main(String args[]) {
int row=9;
for(int i=1;i<=row;i++) {
	for(int j=1;j<=i;j++) {
		System.out.printf("%d*%d=%2d ",i,j,i*j);
	}
	System.out.println("");
}
solution List=new solution();
Node n1=new Node(1);
Node n2=new Node(2);
Node n3=new Node(5);
n1.next=n2;
n2.next=n3;
Node head=List.reverse(n1);
List.display(head);//建立一个对象才被引用方法
//List.display2(head);
//error    如果用直接用display(n1);
//直接引用方法必须是静态的
}
}

/*
 * 顶级
 * public class A{
 * 成员级别      （成员变量）
 * public void method(){
 * 方法级别
 * 除变量语句外，语句必须在方法级别中才能出现，如System.out.println
 * }
 *}
 *class animal{}
 *class dog extends animal{}
 *如何正确建立对象
 *animal a=new animal();
 *dog b=new dog();
 *多态类型
 animal ab=new dog();
 怎么理解这种情况呢，其实就是用大的存储空间去存储，没错最好想到的就是double a=6;
 你本来可以用4个字节的int形式，非要用8个字节存储也可以吧
 //结论左父右子
 interface IC{}
 class C implements IC{}//接口就是作业与备忘录的关系，备忘录就类似与父类与子类关系中的父类
 IC ic=new C();
 设计一个表现多态的，数组类型的引用
 Object[] array=new String[10];
 
 变量的生命周期
 栈区存放着形参和局部变量
 堆区存放着属性 
 栈的销毁首先调用main-》a-》b->c
 main
 a
 b
 c
 public class A{
 public static void c(){}
 public static void b(){c();}
 public static void a(){b();}
 public static void main(String[] args){
 a[];
 }
 }
 
关键字instanceof 返回一个bool用来判断继承中的子类的实例是否为父类的实现

变量的定义语法
属性：修饰符、属性类型(所有数据类型)，属性名，默认值
属性          基本数据类型                       小写开头 下一个单词首字母大写
静态属性   引用数据类型                             int countOfArray
（1）在内存上为这个变量保存一块区域
（2）用变量名关联到该区域
作用域
意思：空间上，变量名和该区域关联生效的范围（scope）
作用域：空间上的//静态的
生命周期：时间上的//动态的

static只能出现在成员级别
static和对象进行解绑
表现为（1）静态属性
（2）静态方法
（3）静态
 */
/*
 * class Outter{
 * class Inner{}
 * static class StaticInner{}
 * }
 * new Outter.StaticInner();
 * new Outter().new Inner();
 */

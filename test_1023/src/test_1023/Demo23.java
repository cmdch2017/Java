package test_1023;
class Student23{
	String name;
	char gender;
	int age;
	String[] courseNames;
	double[] courseScores;
	public Student23() {
		name="unknown name!";
		gender='M';
		age=0;
		courseNames=new String[3];
		courseScores=new double[3];
		courseNames[0]="计算机";
		courseNames[1]="数学";
		courseNames[2]="英语";
	}
	public Student23(String n,char s,int a) {
		name=n;
		gender=s;
		age=a;
		courseNames=new String[3];
		courseScores=new double[3];
		courseNames[0]="计算机";
		courseNames[1]="数学";
		courseNames[2]="英语";
	}
	public void introduceMe() {
		System.out.println("我的名字是： "+name);
		System.out.println("我的性别和年龄分别是: "+gender+"、"+age);
		System.out.println("我的成绩还没有录入！");
	}
}
public class Demo23 {
	public static void main(String[] args) {
		Student23 stu1=new Student23();
		Student23 stu2=new Student23("张山",'M',23);
		stu1.introduceMe();
		System.out.println();
		stu2.introduceMe();
	}
}

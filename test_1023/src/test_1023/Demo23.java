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
		courseNames[0]="�����";
		courseNames[1]="��ѧ";
		courseNames[2]="Ӣ��";
	}
	public Student23(String n,char s,int a) {
		name=n;
		gender=s;
		age=a;
		courseNames=new String[3];
		courseScores=new double[3];
		courseNames[0]="�����";
		courseNames[1]="��ѧ";
		courseNames[2]="Ӣ��";
	}
	public void introduceMe() {
		System.out.println("�ҵ������ǣ� "+name);
		System.out.println("�ҵ��Ա������ֱ���: "+gender+"��"+age);
		System.out.println("�ҵĳɼ���û��¼�룡");
	}
}
public class Demo23 {
	public static void main(String[] args) {
		Student23 stu1=new Student23();
		Student23 stu2=new Student23("��ɽ",'M',23);
		stu1.introduceMe();
		System.out.println();
		stu2.introduceMe();
	}
}
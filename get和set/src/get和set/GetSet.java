package get��set;
class Student{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void test() {
		System.out.println(name+age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>=0) {
		this.age = age;
	}
		else {
			System.out.println("error");
		}
}
	//��������������ͬ���������޲Σ�
	//�ڷ�������ǰ��û�з���ֵ���͵�����
	//�ڷ����в���ʹ��return��䷵��һ��ֵ
	public Student() {
		System.out.println("�޲εķ�������");
	}
}
public class GetSet {
 public static void main(String[] args) {
	 Student stu=new Student();
	 //���޲β����캯��
	 //���趨
	 //�����Ե��ú���
	 System.out.println("ע��1");
	 stu.setName("owen");
	 System.out.println("ע��2");
	 stu.setAge(6);
	 System.out.println("ע��3");
	 stu.test();
	
 }
}

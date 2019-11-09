package get和set;
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
	//方法名与类名相同（先运行无参）
	//在方法名的前面没有返回值类型的声明
	//在方法中不能使用return语句返回一个值
	public Student() {
		System.out.println("无参的方法调用");
	}
}
public class GetSet {
 public static void main(String[] args) {
	 Student stu=new Student();
	 //先无参并构造函数
	 //再设定
	 //最后测试调用函数
	 System.out.println("注意1");
	 stu.setName("owen");
	 System.out.println("注意2");
	 stu.setAge(6);
	 System.out.println("注意3");
	 stu.test();
	
 }
}

package test_1023;
class Student{
	 Student(int sno,String sname){
		no=sno;
		name=sname;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	int no=0;
	String classNum="1";
	String name="a";
	int sex=0;
	int age=10;
}
public class Solution {
	public static void main(String[] args) {
		Student s=new Student(16,"a");
		s.setAge(20);
		System.out.println(s.getAge());
	}
}

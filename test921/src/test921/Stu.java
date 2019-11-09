package test921;

import java.util.Scanner;

class Student{
	String name;
	String sex;
	String English=null;
	String Math=null;
	int age;
	public Student(String name,String sex,String English,String Math,int age) {
		this.name=name;
		this.sex=sex;
		this.English=English;
		this.Math=Math;
		this.age=age;
	}
}
public class Stu {
	/*public static float getAverage(Student[] students) {
		int sum=0;
		for(int i=0;i<students.length;i++) {
			sum+=students[i].age;
		}
		return sum/students.length;
	}*/
	public static void main(String[] args) {
		//没有录入的课程设为null
		Student[] s = {new Student("a", "male", "English", "Math", 60), new Student("b", "male", null, "Math", 30),new Student("b", "feMale", "English", "Math", 30)};
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int countMale=0;
		int countFemale=0;
		int MathcountMale=0;
		int MathcountFemale=0;
		//English
		for(Student i:s) {
			//手动调节是哪个课程
			if(i.English!=null) {
			if(i.sex=="male") {
				countMale++;
			}
			if(i.sex=="feMale") {
				countFemale++;
			}
			}
		}
		if(name.equals("English")) {
			System.out.println(countMale);
			System.out.println(countFemale);
			}
		//Math
		for(Student i:s) {
			//手动调节是哪个课程
			if(i.Math!=null) {
			if(i.sex=="male") {
				MathcountMale++;
			}
			if(i.sex=="feMale") {
				MathcountFemale++;
			}
			}
		}
		if(name.equals("Math")) {
			System.out.println("male: "+MathcountMale);
			System.out.println("female: "+MathcountFemale);
		}
	//示例：输入：Math
	//	输出： 2
	//	     1
	//    输入：English
	//  输出：1
	//       1
	}
}

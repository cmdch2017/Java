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
		//û��¼��Ŀγ���Ϊnull
		Student[] s = {new Student("a", "male", "English", "Math", 60), new Student("b", "male", null, "Math", 30),new Student("b", "feMale", "English", "Math", 30)};
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int countMale=0;
		int countFemale=0;
		int MathcountMale=0;
		int MathcountFemale=0;
		//English
		for(Student i:s) {
			//�ֶ��������ĸ��γ�
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
			//�ֶ��������ĸ��γ�
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
	//ʾ�������룺Math
	//	����� 2
	//	     1
	//    ���룺English
	//  �����1
	//       1
	}
}

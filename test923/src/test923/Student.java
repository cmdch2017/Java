package test923;

import java.util.Random;
import java.util.Scanner;

public class Student {
	String major;
	String sex;
	Student(String major,String sex){
		this.major=major;
		this.sex=sex;
	}
	@Override
	public String toString() {
		return "Student [major=" + major + ", sex=" + sex + "]";
	}
	public static void main(String[] args) {
		//Student[] student= {new Student("Maths", 1),new Student("English",0),new Student("Chinese",1)};
		String[] majors= {"数学","英语","语文","计算机","体育"};
		String[] sex= {"男","女"};
		Random majorrandom=new Random(923);
		Random genderrandom=new Random(923);
		Student[] student=new Student[10];
		for(int i=0;i<10;i++) {
			int m=majorrandom.nextInt(5);
			int g=genderrandom.nextInt(2);
			student[i]=new Student(majors[m],sex[g]);
		}
		for(Student i:student) {
			System.out.println(i.toString());
		}
		Scanner sc=new Scanner(System.in);
		int mancount=0,womancount=0;
		String name=sc.next();
		for(Student i:student) {
			if(i.major.equals(name)) {
				if(i.sex.equals("男"))
				mancount++;
				else
				womancount++;
			}
	}
		System.out.println("man:"+mancount+"  "+"woman:"+womancount);
}
}

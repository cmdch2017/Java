package test_1023;

public class Course8 {
	private String cNumber;
	private String Cname;
	private double Cuit;
	Course8(){
		cNumber="a6";
		Cname="Ä¾Ö®±¾Ó£";
		Cuit=4.5;
	}
	public void printCourseInfo(){
		System.out.println(String.format(Cname+"  "+cNumber+" "+Cuit));
	}
	public static void main(String[] args) {
		Course8 l=new Course8();
		l.printCourseInfo();
	}
}

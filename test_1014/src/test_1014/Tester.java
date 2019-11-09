package test_1014;

public class Tester{
 public static String replaceSpace(String oldString) {
	 StringBuilder newString=new StringBuilder();
		for(String i:oldString.split(" ")) { 
			newString.append(i+"%20");
		}
		String a=newString.substring(0, newString.length()-3);
		return a;
 }
 public static void main(String[] args) {
	 String oldString=new String("acs happy");
	 String a=replaceSpace(oldString);
			System.out.println(a);
 }
}
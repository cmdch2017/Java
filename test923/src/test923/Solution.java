package test923;

import java.util.Scanner;

public class Solution {
	String major;
	int sex;
	Solution(String major,int sex){
		this.major=major;
		this.sex=sex;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		Solution[] student= {new Solution("Maths", 1),new Solution("English",0),new Solution("Chinese",1)};
		int mancount = 0,womancount = 0;
		for(Solution i:student) {
			if(name.equals(i.major)) {
				if(i.sex==1)
				mancount++;
				else
				womancount++;
			}
		}
		System.out.println("man: "+mancount+"  "+"woman: "+womancount);
	}
	
	
}

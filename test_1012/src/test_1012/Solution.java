package test_1012;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	HashSet<String> set=new HashSet<>();
    	do {
    		Scanner sc=new Scanner(System.in);
    		String str=sc.nextLine();
    		if(str.equals("")) {
    			break;
    		}
    		for(String i:str.split(" "))
    		set.add(i);
    	}while(true);
    	System.out.println(set.size());
}
}

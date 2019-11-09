package test_113;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public static void main(String[] args) {
		//Old way:
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		for(Integer n: list) {
		   System.out.println(n);
		}
		
		//New way:
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list2.forEach(n -> System.out.println(n));
		
		//or we can use :: double colon operator in Java 8
		//list.forEach(System.out::println);
	}
}
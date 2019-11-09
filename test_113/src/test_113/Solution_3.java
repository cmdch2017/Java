package test_113;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Solution_3 {

	//计算 count, min, max, sum, and average for numbers  
public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  

	IntSummaryStatistics stats = numbers  
			
	          .stream()  

	          .mapToInt((x) -> x)  

	          .summaryStatistics();  

	  

	System.out.println("List中最大的数字 : " + stats.getMax());  

	System.out.println("List中最小的数字 : " + stats.getMin());  

	System.out.println("所有数字的总和   : " + stats.getSum());  

	System.out.println("所有数字的平均值 : " + stats.getAverage());  
}
}

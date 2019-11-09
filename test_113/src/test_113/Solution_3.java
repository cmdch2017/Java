package test_113;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Solution_3 {

	//���� count, min, max, sum, and average for numbers  
public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  

	IntSummaryStatistics stats = numbers  
			
	          .stream()  

	          .mapToInt((x) -> x)  

	          .summaryStatistics();  

	  

	System.out.println("List���������� : " + stats.getMax());  

	System.out.println("List����С������ : " + stats.getMin());  

	System.out.println("�������ֵ��ܺ�   : " + stats.getSum());  

	System.out.println("�������ֵ�ƽ��ֵ : " + stats.getAverage());  
}
}

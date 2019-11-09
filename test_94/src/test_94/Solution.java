package test_94;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
public class Solution {
	//统计数字映射关系
public static  Map<Integer,Integer>  count(int[] numbers){
	Map<Integer,Integer> map=new HashMap<>();
   //关键字 key:数字
   //值         value：该数字出现的次数
   //桶排序
	for(int n:numbers) {
    	int c=map.getOrDefault(n, 0);//存在返回n，否则返回0(0为初始出现次数)
    	map.put(n, c+1);//键值对赋值
    }
	return map;	
}
//宝石与石头
public int numJewelsInStones(String J,String S) {
	int count=0;
	Set<Character> set=new HashSet<>();
	for(char ch:J.toCharArray()) {
		set.add(ch);
	}
	for(char ch:S.toCharArray()) {
		if(set.contains(ch))
			count++;
	}
	return count;
}
public static void main(String[] args) {
	/*int[] array= {0,1,2,3,6,3,2,4,2,1,0,2};
	Map<Integer,Integer> map=count(array);
	System.out.println(map);
    for(Map.Entry<Integer, Integer> entry:map.entrySet()){
    int count=entry.getValue();
    if(count==1)
    	System.out.println(entry.getKey());
    }*/
	@SuppressWarnings("resource")
	Scanner scanner =new Scanner(System.in);
	String expected=scanner.nextLine();
	String actual=scanner.nextLine();
	Set<Character> set=new HashSet<>();
	//不区分大小写，统一把字符串转为大写
	char[] a=actual.toUpperCase().toCharArray();
	for(char c:a) {
		set.add(c);
	}
	char[] b=expected.toUpperCase().toCharArray();
	Set<Character> brokenKeys= new HashSet<>();
	for(char c:b) {
		if(!set.contains(c)) {
			//如果没有打印过
			if(!brokenKeys.contains(c)) {
				System.out.println(c);
				brokenKeys.add(c);
			}
		}
		//if(!set.contains(c)) {
			//System.out.println(c);
		//}
	}
    }
}
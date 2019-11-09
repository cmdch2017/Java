package test98;
import java.util.*;
public class Solution {
public List<String> subdomainVisits(String[] cpdomains){
	Map<String,Integer> map=new HashMap<>();
	for(String n:cpdomains) {
		String[] t=n.split(" ");
	//	parseInt可以吗
		int count=Integer.valueOf(t[0]);
		String[] a=t[1].split("\\.");
		for(int i=0;i<a.length;i++) {
			String[] sub=Arrays.copyOfRange(a, i, a.length);//指定范围放到新数组
			String d=String.join(".", sub);
			map.put(d, map.getOrDefault(d, 0)+count);
		}
	}
	System.out.println(map);
	List<String> result=new ArrayList<>();
	return result;
}
public static void main(String[] args) {
	String[] s= {"900 google.mail.com","50 yahoo.com"};
	List <String> l=new Solution().subdomainVisits(s);
	System.out.println(l);
}
}

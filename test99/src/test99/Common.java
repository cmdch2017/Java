package test99;
import java.util.*;
public class Common {
	public static List<String> commonChars(String[] A){
	List<String> list=new ArrayList<>();
	//1.统计每个单词中，每个字母的出现次数	
		List<Map<Character,Integer>> counts=new ArrayList<>();
      for(String s:A) {
    	  Map<Character,Integer> map=new HashMap<>();
    	 for(char c:s.toCharArray()) {
    		 map.put(c,map.getOrDefault(c, 0)+1); 
    	 }
    	 counts.add(map);
      }
     // System.out.println(counts);
      //从counts找出abel
for(char c:counts.get(0).keySet()) {
	boolean allContains=true;
	for(int i=1;i<counts.size();i++) {
		Map<Character,Integer> map=counts.get(i);
		if(!map.containsKey(c)) {
			allContains=false;
			break;
		}
	}
	if(!allContains) {
		continue;
	}
	int min=counts.get(0).get(c);
	for(int i=1;i<counts.size();i++) {
		int n=counts.get(0).get(c);
		if(n<min)
			min=n;
	}
	for(int i=0;i<min;i++) {
		list.add(String.valueOf(c));
	}
}
  	return list;
}
	public static void main(String[] args) {
		String[] A= {"bella","label","roller"};
		System.out.println(commonChars(A));
	}
}

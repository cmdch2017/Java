package test99;
import java.util.*;
public class Solution {
public static List<String> commonChars(String[] A){
	//初始化ans[]=max,temp[]=0
	int[] ans=new int[26];
	for(int i=0;i<26;i++) ans[i]=Integer.MAX_VALUE;//注意赋值for each不能用
	for(String str:A) {
		int[] temp=new int[26];
		//再开始拆分成字符
		for(char c:str.toCharArray()) {
			temp[c-'a']++;
		}
		for(int i=0;i<26;i++) {
			ans[i]=Math.min(ans[i], temp[i]);
		}
	}
	List<String> list=new ArrayList<>();
	for(int i=0;i<26;i++) {
		while(ans[i]>0) {
			list.add(""+(char)('a'+i));
			ans[i]--;
		}
	}
	return list;
	
}
public static void main(String[] args) {
	String[] array= {"bella","label","roller"};
	List<String> list=new ArrayList<>();
	list.add("a");
	System.out.println(list);

	List<String> list2=commonChars(array);
	System.out.println(list2);
}

}

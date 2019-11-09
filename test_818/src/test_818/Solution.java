package test_818;
import java.util.Map;
import java.util.HashMap;
public class Solution {
public static void main(String[] args) {
	//多态
	Map<String,String> map=new HashMap<>();
	System.out.println(map.size());
	System.out.println(map.isEmpty());
	System.out.println(map.get("作者"));
	System.out.println(map.getOrDefault("作者","佚名"));
	System.out.println(map.containsKey("作者"));
	System.out.println(map.containsValue("佚名"));
	map.put("作者","鲁迅");
	System.out.println();
	System.out.println(map.size());
	System.out.println(map.isEmpty());
	System.out.println(map.get("作者"));
	System.out.println(map.getOrDefault("作者","佚名"));
	System.out.println(map.containsKey("作者"));
	System.out.println(map.containsValue("佚名"));
	//静态内部类，类似于Outter.Intter
	for(Map.Entry<String, String>entry:map.entrySet()) {
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}
}
}

package test_818;
import java.util.Map;
import java.util.HashMap;
public class Solution {
public static void main(String[] args) {
	//��̬
	Map<String,String> map=new HashMap<>();
	System.out.println(map.size());
	System.out.println(map.isEmpty());
	System.out.println(map.get("����"));
	System.out.println(map.getOrDefault("����","����"));
	System.out.println(map.containsKey("����"));
	System.out.println(map.containsValue("����"));
	map.put("����","³Ѹ");
	System.out.println();
	System.out.println(map.size());
	System.out.println(map.isEmpty());
	System.out.println(map.get("����"));
	System.out.println(map.getOrDefault("����","����"));
	System.out.println(map.containsKey("����"));
	System.out.println(map.containsValue("����"));
	//��̬�ڲ��࣬������Outter.Intter
	for(Map.Entry<String, String>entry:map.entrySet()) {
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}
}
}
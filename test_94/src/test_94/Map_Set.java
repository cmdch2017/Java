package test_94;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Map_Set {
public static void main(String[] args) {
	//Integer->String
	Map<Integer,String> map=new HashMap<>();
	map.put(1, "hello");
	map.put(3, "Java");
	map.put(2, "Bit");
	System.out.println(map);
	System.out.println(map.get(6));
	System.out.println(map.get(2));
	for (Map.Entry<Integer,String> entry:map.entrySet()) {
		System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}

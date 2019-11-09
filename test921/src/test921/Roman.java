package test921;

import java.util.HashMap;
import java.util.Map;
public class Roman {
	public static int romanToInt(String s) {
		Map <Character,Integer> map=new HashMap<>();
		map.put('I',1);
		map.put('X',10);
		map.put('V',5);
		map.put('L',100);
		int result=0;
		for(int i=0;i<s.length();i++) {
			if(i>0&&map.get(s.charAt(i))>map.get(s.charAt(i-1))) {
				result+=map.get(s.charAt(i))-2*map.get(s.charAt(i-1));
			}
			else {
			result+=map.get(s.charAt(i));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String a="VI";
		System.out.println(romanToInt(a));
	}
}

package test_94;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word {
	Map<String,Integer> count (String[] words){
	Map<String,Integer> map=new HashMap<>();
		for(String n:words) {
	    	map.put(n, map.getOrDefault(n, 0)+1);
	    }
		return map;	
	}
	//ÿ������=>>��Щ����
	Map<Integer,List<String>> remap(Map<String,Integer> wordTocount){
		for(Map.Entry<String, Integer>e:wordTocount.entrySet()) {
			String word=e.getKey();
			int count=e.getValue();
			//List<String> wordList=
		}
		return null;
	}
	public static void main(String[] args) {
		Map<Integer,Integer> map=null;
	}
}
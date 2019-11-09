package stringtest;
//子串在整串中出现次数
public class Stringtest {
public static void main(String[] args) {
	String str="nbaernbatnbaynbauinbaopnbanba";
	String key="nba";
	int count=getKeyStringCount(str,key);
	System.out.println("count="+count);
}
public static int getKeyStringCount(String str,String key) {
	int count=0;
	//遍历一遍，如果没有就返回0;
	if(!str.contains(key)) {
		return count;
	}
	int index=0;
	//找不到时indexOf()返回值为-1
	while((index=str.indexOf(key))!=-1) {
		// "unhappy".substring(2) returns "happy"
		str=str.substring(index+key.length());
		count++;
	}
	return count++;
}
}

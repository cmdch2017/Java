package stringtest;
//�Ӵ��������г��ִ���
public class Stringtest {
public static void main(String[] args) {
	String str="nbaernbatnbaynbauinbaopnbanba";
	String key="nba";
	int count=getKeyStringCount(str,key);
	System.out.println("count="+count);
}
public static int getKeyStringCount(String str,String key) {
	int count=0;
	//����һ�飬���û�оͷ���0;
	if(!str.contains(key)) {
		return count;
	}
	int index=0;
	//�Ҳ���ʱindexOf()����ֵΪ-1
	while((index=str.indexOf(key))!=-1) {
		// "unhappy".substring(2) returns "happy"
		str=str.substring(index+key.length());
		count++;
	}
	return count++;
}
}

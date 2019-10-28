package 通讯录;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	private static String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Solution(String note,String telephone){
		this.note=note;
		this.telephone=telephone;
	}
	public Solution() {
		// TODO 自动生成的构造函数存根
	}
	private String note;
	private String telephone;
	static Map<String,Solution> map=new HashMap<>();
	@SuppressWarnings("unchecked")
	public static boolean add(String name,String note,String telephone) {
		//List<Solution> list=new ArrayList<>();
		System.out.println("正在添加中，请稍后");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Solution l=new Solution(note,telephone);
		map.put(name,  l);
		return true;		
	}
	public static void delete(String name) {
		map.remove(name);
	}
	public boolean search(String name) {
		//遍历map，查找key值
		boolean isSearched=false;
		//map的映射
		Set<Map.Entry<String, Solution>> entries=map.entrySet();
		for(Map.Entry<String,Solution> entry:entries) {
			if(entry.getKey().equals(name)) {
				System.out.println(entry.getValue().toString());
				isSearched=true;
			}
		}
		if(!isSearched) {
			System.out.println("没找到对应的名字");
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Solution [note=" + note + ", telephone=" + telephone + "]";
	}
	public  void update(String name,String note,String telephone) {
		if(!search(name)) {;
		try {
			throw new Exception("无法完成更新");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}
		Solution s=new Solution(note,telephone);
		map.replace(name,  s);
	}
	/*public static List<Solution> add(String name,String note,String telephone) {
		List<Solution> list=new ArrayList<>();
		Solution l=new Solution();
		l.add(name, note, telephone);
		list.add(l);
		return list;
		
	}
	*/
	public static void main(String[] args) throws InterruptedException {
		Solution s=new Solution();
		System.out.println("****添加功能****");
		s.add("he","123","1234678");
		s.add("Cat", "123", "21313");
		System.out.println("****请输入要查找的姓名*****");
		s.search("he");
		s.search("Cat");
		System.out.println("****删除功能*****");
		s.delete("Cat");
		s.search("Cat");
		System.out.println("****更新功能****");
	/*	s.update("Cat", "12345", "121");
		s.search("Cat");*/
		Thread.sleep(1000);
		s.add("Cat", "123", "222");
		s.update("Cat", "12345", "121");
		s.search("Cat");
	}

}

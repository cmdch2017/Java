package ͨѶ¼;

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
		// TODO �Զ����ɵĹ��캯�����
	}
	private String note;
	private String telephone;
	static Map<String,Solution> map=new HashMap<>();
	@SuppressWarnings("unchecked")
	public static boolean add(String name,String note,String telephone) {
		//List<Solution> list=new ArrayList<>();
		System.out.println("��������У����Ժ�");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
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
		//����map������keyֵ
		boolean isSearched=false;
		//map��ӳ��
		Set<Map.Entry<String, Solution>> entries=map.entrySet();
		for(Map.Entry<String,Solution> entry:entries) {
			if(entry.getKey().equals(name)) {
				System.out.println(entry.getValue().toString());
				isSearched=true;
			}
		}
		if(!isSearched) {
			System.out.println("û�ҵ���Ӧ������");
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
			throw new Exception("�޷���ɸ���");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
		System.out.println("****��ӹ���****");
		s.add("he","123","1234678");
		s.add("Cat", "123", "21313");
		System.out.println("****������Ҫ���ҵ�����*****");
		s.search("he");
		s.search("Cat");
		System.out.println("****ɾ������*****");
		s.delete("Cat");
		s.search("Cat");
		System.out.println("****���¹���****");
	/*	s.update("Cat", "12345", "121");
		s.search("Cat");*/
		Thread.sleep(1000);
		s.add("Cat", "123", "222");
		s.update("Cat", "12345", "121");
		s.search("Cat");
	}

}

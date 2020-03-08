package test_121;

import java.io.*;

import java.util.ArrayList;

 

public class AppDAO {
	//�������е���Ϣ
	public ArrayList<String> findAllFlowers()
	{
		SelectReview l=new SelectReview();
		return l.select();
	}
	
	//ͨ����������һ�����Ϣ
	
	public static String findFlowerBySno(String sno){
		String result="������";
		SelectByNo l=new SelectByNo();
		if(l.select(sno)!=null) {
		result=l.select(sno);
		}
		return result;
	}


	//ͨ�����������һ�����Ϣ

	private static void print(String result) {
		// TODO �Զ����ɵķ������
		System.out.println(result.toString());
	}
	
	public static String findFlowerBySname(String sname){
		String result="������";
		SelectByName l=new SelectByName();
		if(l.select(sname)!=null) {
		result=l.select(sname);
		}
		return result;
	}
	
	
	

	//���Ӽ�¼

	public boolean AddFlower(String Floinfo){
		String[] strs=Floinfo.split(",");
		if(numIsExist(strs[0])) {
			System.out.println("error");
			return false;
		}
		Insert l=new Insert();
		l.insertStudent(Floinfo);
		return true;
	}

	

	//�ж��Ƿ��Ѿ������ظ��ı��

	public static boolean numIsExist(String num){
		String result=null;
		SelectByNo l=new SelectByNo();
		if(l.select(num)!=null) {
		result=l.select(num);
		}
		String[] strs=result.split(",");
		return num.equals(strs[0]);
	}

	

	//�ж������Ƿ��ظ�
	
	public boolean nameIsExist(String name){
		String result=null;
		SelectByName l=new SelectByName();
		if(l.select(name)!=null) {
		result=l.select(name);
		}
		String[] strs=result.split(",");
		return name.equals(strs[1]);
	}


	//ɾ��һ�������¼�ķ���
	public static boolean DeleteFlower(String num) {
		if(!numIsExist(num)) {
			System.out.println("error");
			return false;
		}
		else {
			Delete l=new Delete();
			l.deleteStudent(num);
		}
		return true;
	}
	
	//�޸�һ����¼�ķ���
	public boolean ModifyFlower(String Floinfo) {
		String[] strs=Floinfo.split(",");
		if(!numIsExist(strs[0])) {
			System.out.println("error");
			return false;
		}
		Update l=new Update();
		l.updateStudent(Floinfo);
		return true;
	}
	
}

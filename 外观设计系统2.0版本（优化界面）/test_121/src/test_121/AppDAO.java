package test_121;

import java.io.*;

import java.util.ArrayList;

 

public class AppDAO {
	//查找所有的信息
	public ArrayList<String> findAllFlowers()
	{
		SelectReview l=new SelectReview();
		return l.select();
	}
	
	//通过编号来查找基本信息
	
	public static String findFlowerBySno(String sno){
		String result="不存在";
		SelectByNo l=new SelectByNo();
		if(l.select(sno)!=null) {
		result=l.select(sno);
		}
		return result;
	}


	//通过名称来查找基本信息

	private static void print(String result) {
		// TODO 自动生成的方法存根
		System.out.println(result.toString());
	}
	
	public static String findFlowerBySname(String sname){
		String result="不存在";
		SelectByName l=new SelectByName();
		if(l.select(sname)!=null) {
		result=l.select(sname);
		}
		return result;
	}
	
	
	

	//增加记录

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

	

	//判断是否已经存在重复的编号

	public static boolean numIsExist(String num){
		String result=null;
		SelectByNo l=new SelectByNo();
		if(l.select(num)!=null) {
		result=l.select(num);
		}
		String[] strs=result.split(",");
		return num.equals(strs[0]);
	}

	

	//判断名称是否重复
	
	public boolean nameIsExist(String name){
		String result=null;
		SelectByName l=new SelectByName();
		if(l.select(name)!=null) {
		result=l.select(name);
		}
		String[] strs=result.split(",");
		return name.equals(strs[1]);
	}


	//删除一条花朵记录的方法
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
	
	//修改一条记录的方法
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

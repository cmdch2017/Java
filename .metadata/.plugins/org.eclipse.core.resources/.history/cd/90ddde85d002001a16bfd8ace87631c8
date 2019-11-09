//对于学生文件进行操作的类
import java.io.*;
import java.util.*;
public class StudentDeal {
	//通过学号来查找姓名
	public String findNameByNum(String num)
	{
		String name="查无此人";
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			//创建一个字符文件输入流
			BufferedReader br=new BufferedReader(fr);
			//创建一个缓冲的字符输入流
			String str=br.readLine();//一次读取一行数据
			while(str!=null)
			{
				String[] infos=str.split(",");
				//将一行数据进行切割，得到一个数组
				if(infos[0].equals(num))
				{
					name=infos[1];
					break;//退出循环
				}
				str=br.readLine();//再次读取一行数据
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	//通过姓名来查找学号
	public String findNumByName(String name)
	{
		String num="查无此号";
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			//创建一个字符文件输入流
			BufferedReader br=new BufferedReader(fr);
			//创建一个缓冲的字符输入流
			String str=br.readLine();//一次读取一行数据
			while(str!=null)
			{
				String[] infos=str.split(",");
				//将一行数据进行切割，得到一个数组
				if(infos[1].equals(name))
				{
					num=infos[0];
					break;//退出循环
				}
				str=br.readLine();//再次读取一行数据
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public String findResultByPara(String paraName,String paraValue)
	{
		String result="";
		int i,j=0;
		if(paraName.equals("姓名"))
		{
			result="查无此人";
			i=1;
			j=0;
		}
		else
		{
			result="查无此号";
			i=0;
			j=1;
		}
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			//创建一个字符文件输入流
			BufferedReader br=new BufferedReader(fr);
			//创建一个缓冲的字符输入流
			String str=br.readLine();//一次读取一行数据
			while(str!=null)
			{
				String[] infos=str.split(",");
				//将一行数据进行切割，得到一个数组
				if(infos[i].equals(paraValue))
				{
					result=infos[j];
					break;//退出循环
				}
				str=br.readLine();//再次读取一行数据
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int getStudentCountBySex(String sex)
	{
		int count=0;
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			//创建一个字符文件输入流
			BufferedReader br=new BufferedReader(fr);
			//创建一个缓冲的字符输入流
			String str=br.readLine();//一次读取一行数据
			while(str!=null)
			{
				String[] infos=str.split(",");
				//将一行数据进行切割，得到一个数组
				if(infos[2].equals(sex))
				{
					count++;
				}
				str=br.readLine();//再次读取一行数据
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//增加一条学生记录
	public void addStudent(StudentInfo stu)
	{
		if(!isExist(stu.getNum()))
		{
			try {
				FileWriter fw = new FileWriter("d:\\student.txt", true);
				// 创建一个字符文件输出流
				BufferedWriter bw = new BufferedWriter(fw);
				// 创建一个缓冲的字符输出流
				StringBuffer str = new StringBuffer();
				str.append(stu.getNum() + ",");
				str.append(stu.getName() + ",");
				str.append(stu.getSex());
				bw.newLine();
				bw.write(str.toString());
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//判断学号是否存在的方法
	private boolean isExist(String num)
	{
		boolean result=false;
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			//创建一个字符文件输入流
			BufferedReader br=new BufferedReader(fr);
			//创建一个缓冲的字符输入流
			String str=br.readLine();//一次读取一行数据
			while(str!=null)
			{
				String[] infos=str.split(",");
				//将一行数据进行切割，得到一个数组
				if(infos[0].equals(num))
				{
					result=true;
					break;//退出循环
				}
				str=br.readLine();//再次读取一行数据
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private ArrayList<String> getAllStudents()
	{
		ArrayList<String> result=new ArrayList<String>();
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			//创建一个字符文件输入流
			BufferedReader br=new BufferedReader(fr);
			//创建一个缓冲的字符输入流
			String str=br.readLine();//一次读取一行数据
			while(str!=null)
			{
				result.add(str);
				str=br.readLine();//再次读取一行数据
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//更新学生记录的方法
	public void updateStudent(StudentInfo stu)
	{
		if(isExist(stu.getNum()))
		{
			ArrayList<String> oldList=getAllStudents();
			//先获取原先文件中的所有学生信息
			for(int i=0;i<oldList.size();i++)
			{
				if(oldList.get(i).toString().split(",")[0].equals(stu.getNum()))
				{
					oldList.remove(i);
					StringBuffer str = new StringBuffer();
					str.append(stu.getNum() + ",");
					str.append(stu.getName() + ",");
					str.append(stu.getSex());
					oldList.add(str.toString());
					break;
				}
			}
			try {
				FileWriter fw = new FileWriter("d:\\student.txt");
				// 创建一个字符文件输出流
				BufferedWriter bw = new BufferedWriter(fw);
				// 创建一个缓冲的字符输出流
			    for(int i=0;i<oldList.size();i++)
			    { 	
			    	bw.write(oldList.get(i).toString());
			    	bw.newLine();
			    }
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//删除学生记录的方法
	public void deleteStudent(String num)
	{
		if(isExist(num))
		{
			ArrayList<String> oldList=getAllStudents();
			//先获取原先文件中的所有学生信息
			for(int i=0;i<oldList.size();i++)
			{
				if(oldList.get(i).toString().split(",")[0].equals(num))
				{
					oldList.remove(i);
					break;
				}
			}
			try {
				FileWriter fw = new FileWriter("d:\\student.txt");
				// 创建一个字符文件输出流
				BufferedWriter bw = new BufferedWriter(fw);
				// 创建一个缓冲的字符输出流
			    for(int i=0;i<oldList.size();i++)
			    { 	
			    	bw.write(oldList.get(i).toString());
			    	bw.newLine();
			    }
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

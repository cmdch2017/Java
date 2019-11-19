package test_121;

import java.io.*;

import java.util.ArrayList;

 

public class FlowerDAO {
	//查找所有的花卉信息
	public ArrayList<String> findAllFlowers()
	{
		SelectReview l=new SelectReview();
		return l.select();
	}
	
	//通过编号来查找花朵的基本信息
	
	public static String findFlowerBySno(String sno){
		String result="不存在";
		SelectByNo l=new SelectByNo();
		if(l.select(sno)!=null) {
		result=l.select(sno);
		}
		return result;
	}


	//通过名称来查找花朵的基本信息

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
	
	

	//通过名称来查找花朵的基本信息
/*
	public String findFlowerByname(boolean bool,String name)

	{

		String result="不存在这个花朵";

		try {

			FileReader fr=new FileReader("Flower.txt");

			//产生了一个文件字符输入流对象

			BufferedReader br=new BufferedReader(fr);

			//以上一个对象作为参数来创建一个缓冲的字符输入流对象

			String str=br.readLine();//读取一行数据

			boolean flag=true;

			while(flag)

			{

				String temp=str;

				if(!bool)

				{

					temp=str.substring(4);

				}

				if(temp.startsWith(name.trim()))

				{

					result=str;

					flag=false;

				}

				str=br.readLine();//继续读取下一行

				if(str==null)

				{

					flag=false;

				}

			}

			br.close();

			fr.close();

		}

		catch (FileNotFoundException e) {

			// TODO Auto-generated catch block

			System.out.println("文件未找到");

		}

		catch (IOException e) {

			// TODO Auto-generated catch block

			System.out.println("文件读错误");

		}

		return result;

	}
*/
	

	//增加一条花朵记录

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
	public boolean ModifyFlower2(String Floinfo)

	{

		String[] strs=Floinfo.split(",");

		if(numIsExist(strs[0]))

		{

			try

			{

				FileReader fr=new FileReader("Flower.txt");

				//产生了一个文件字符输入流对象

				BufferedReader br=new BufferedReader(fr);

				//以上一个对象作为参数来创建一个缓冲的字符输入流对象

				String str=br.readLine();//读取一行数据

				ArrayList<String> list=new ArrayList<String>();

				//保存读入的花朵信息

				boolean flag=true;

				while(flag)

				{

					list.add(str);

					str=br.readLine();//再次读取一行数据

					if(str==null)

					{

						flag=false;

					}

				}

				br.close();

				fr.close();

				

				for(int i=0;i<list.size();i++)

				{

					if(list.get(i).startsWith(strs[0]))

					{

						list.remove(i);

						//先从动态数组对象中移除

						list.add(Floinfo);

						//然后再添加修改后的花朵记录

						break;

					}

				}//将对应的花朵记录移除

				FileWriter fw=new FileWriter("Flower.txt");

				//创建一个文件的字符输出流,不需要追加

				BufferedWriter bw=new BufferedWriter(fw);

				//以上面创建的对象为参数创建一个缓冲字符输出流

				for(int i=0;i<list.size();i++)

				{

					bw.write(list.get(i));

					//分别写入花朵记录

				    bw.newLine();

				}

				bw.flush();

				bw.close();

				fw.close();

			}

			catch(IOException ex)

			{

				

			}

			return true;

		}

		else

		{

			return false;

		}

	}

	//修改多条花朵记录
/*
	public int ModifyFlowers(String[] Flos)

	{

		int result=0;

		if(Flos!=null)

		{

			if(Flos.length>0)

			{

				for(int i=0;i<Flos.length;i++)

				{

					if(ModifyFlower(Flos[i]))

					{

						result++;

					}

				}

			}

		}

		return result;

	}
*/
	

}

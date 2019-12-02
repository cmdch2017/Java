package test_121;

import java.io.*;

import java.util.ArrayList;

 

public class FlowerDAO {
	//�������еĻ�����Ϣ
	public ArrayList<String> findAllFlowers()
	{
		SelectReview l=new SelectReview();
		return l.select();
	}
	
	//ͨ����������һ���Ļ�����Ϣ
	
	public static String findFlowerBySno(String sno){
		String result="������";
		SelectByNo l=new SelectByNo();
		if(l.select(sno)!=null) {
		result=l.select(sno);
		}
		return result;
	}


	//ͨ�����������һ���Ļ�����Ϣ

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
	
	

	//ͨ�����������һ���Ļ�����Ϣ
/*
	public String findFlowerByname(boolean bool,String name)

	{

		String result="�������������";

		try {

			FileReader fr=new FileReader("Flower.txt");

			//������һ���ļ��ַ�����������

			BufferedReader br=new BufferedReader(fr);

			//����һ��������Ϊ����������һ��������ַ�����������

			String str=br.readLine();//��ȡһ������

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

				str=br.readLine();//������ȡ��һ��

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

			System.out.println("�ļ�δ�ҵ�");

		}

		catch (IOException e) {

			// TODO Auto-generated catch block

			System.out.println("�ļ�������");

		}

		return result;

	}
*/
	

	//����һ�������¼

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
	public boolean ModifyFlower2(String Floinfo)

	{

		String[] strs=Floinfo.split(",");

		if(numIsExist(strs[0]))

		{

			try

			{

				FileReader fr=new FileReader("Flower.txt");

				//������һ���ļ��ַ�����������

				BufferedReader br=new BufferedReader(fr);

				//����һ��������Ϊ����������һ��������ַ�����������

				String str=br.readLine();//��ȡһ������

				ArrayList<String> list=new ArrayList<String>();

				//�������Ļ�����Ϣ

				boolean flag=true;

				while(flag)

				{

					list.add(str);

					str=br.readLine();//�ٴζ�ȡһ������

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

						//�ȴӶ�̬����������Ƴ�

						list.add(Floinfo);

						//Ȼ��������޸ĺ�Ļ����¼

						break;

					}

				}//����Ӧ�Ļ����¼�Ƴ�

				FileWriter fw=new FileWriter("Flower.txt");

				//����һ���ļ����ַ������,����Ҫ׷��

				BufferedWriter bw=new BufferedWriter(fw);

				//�����洴���Ķ���Ϊ��������һ�������ַ������

				for(int i=0;i<list.size();i++)

				{

					bw.write(list.get(i));

					//�ֱ�д�뻨���¼

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

	//�޸Ķ��������¼
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

package test_107;
public class Human {
	static int num=0;
	private String name;
	private String sex;
	private String humannum;
	private int height;
	private float weight;
	public Human(String name,String sex,String humannum,int height,float weight) {
		this.name=name;
		this.setAge(humannum);
		this.setHeight(height);
		this.setWeight(weight);
		this.setSex(sex);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setAge(String humannum) {
		this.humannum = humannum;
	}
	public String getAge() {
		return humannum;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getWeight() {
		return weight;
	}
	
	public void eat()
	{
		System.out.println(name+"�ڳԷ�");
	}
	
	public void sleep()
	{
		System.out.println(name+"��˯��");
	}	
	public void panduan()
	{
		if(name.length()<=20)
		{
			int i=0;
			for(int n=name.length();n>0;n--)
			{
				int ch=name.charAt(n);
			    if(ch>=0&&ch<=255)
			    	i++;
			}
			if(i==0)
				num++;
			else
				System.out.println("������������!");
		}
		else
			System.out.println("������������!");
		if(sex.equals("��")||sex.equals("Ů"))
			num++;
		else
			System.out.println("�Ա���������!");
		if(name.length()==18)
		{
			int i=0;
			for(int n=17;n>0;n--)
			{
				int ch=name.charAt(n);
			    if(ch<48||ch>57)
			    	i++;
			}
			int chr=name.charAt(18);
			if((chr<48||chr>57)&&chr!='x')
				i++;
			if(i==0)
				num++;
			else
				System.out.println("���֤�Ź���"+i+"λ��������!");
		}
		else
			System.out.println("���֤��λ����������!");
		if(height<=300)
			num++;
		else
			System.out.println("�����������!");
		if(weight<=500)
			num++;
		else
			System.out.println("������������!");
	}
    public String toString() {
		if(num>=1)
		{
			String result="";
		    result="����:"+name+";";
		    result=result+"�Ա�:"+sex+";";
		    result=result+"���֤��:"+humannum+";";
		    result=result+"���:"+height+"����;";
		    result=result+"����:"+weight+"����";
		    return result;
		}
		else
			return "0";
	}

}
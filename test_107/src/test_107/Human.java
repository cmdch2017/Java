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
		System.out.println(name+"在吃饭");
	}
	
	public void sleep()
	{
		System.out.println(name+"在睡觉");
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
				System.out.println("名字输入有误!");
		}
		else
			System.out.println("名字输入有误!");
		if(sex.equals("男")||sex.equals("女"))
			num++;
		else
			System.out.println("性别输入有误!");
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
				System.out.println("身份证号共有"+i+"位输入有误!");
		}
		else
			System.out.println("身份证号位数输入有误!");
		if(height<=300)
			num++;
		else
			System.out.println("身高输入有误!");
		if(weight<=500)
			num++;
		else
			System.out.println("体重输入有误!");
	}
    public String toString() {
		if(num>=1)
		{
			String result="";
		    result="姓名:"+name+";";
		    result=result+"性别:"+sex+";";
		    result=result+"身份证号:"+humannum+";";
		    result=result+"身高:"+height+"厘米;";
		    result=result+"体重:"+weight+"公斤";
		    return result;
		}
		else
			return "0";
	}

}
package test927;
//��ʦ��
public class Teacher {
	private String name;
	private String sex;
	private String num;
	private int age;
	private int teaAge;
	private String zhiCheng;
	private String[] courseNames;
	//��ʦ�������
	public void shangKe()
	{
		System.out.println(name+"���Ͽ�");
	}
	public void beiKe()
	{
		System.out.println(name+"�ڱ���");
	}
	//��ʦ�����Ϊ
	public Teacher(String name,String num,String sex,int age,int teaAge)
	{
		this.name=name;
		this.setNum(num);
		this.setSex(sex);
		this.setAge(age);
		this.setTeaAge(teaAge);
	}
	//��ʦ��Ĺ��췽��
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	//˽�����Ե����úͻ�ȡ����
	public void setSex(String sex) {
		if((sex.equals("��"))||(sex.equals("Ů")))
		{
			this.sex = sex;
		}
	}
	public String getSex() {
		return sex;
	}
	public void setNum(String num) {
		String str=checkNum(num);
		if(str.equals(""))
		{
			this.num = num;
		}
		else
		{
			System.out.println(str);
		}
	}
	
	private String checkNum(String num)
	{
		String result="";
		if(num.length()!=5)
		{
			result="��ʦ��ų��Ȳ���5λ";
		}
		else
		{
			char ch=num.charAt(0);//����ʦ��Ų����ĵ�һ���ַ���������ch
			if(ch!='T')
			{
				result="��ʦ��ŵ�һλ���Ǵ�дT";
			}
			else
			{
				for(int i=1;i<num.length();i++)
				{
					char ch1=num.charAt(i);
					if((ch1<'0')||(ch1>'9'))
					{
						result="��ʦ��ź�4λ�з������ַ�";
						break;
					}
				}
			}
		}
		return result;
	}
	public String getNum() {
		return num;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setTeaAge(int teaAge) {
		this.teaAge = teaAge;
	}
	public int getTeaAge() {
		return teaAge;
	}
	public void setZhiCheng(String zhiCheng) {
		this.zhiCheng = zhiCheng;
	}
	public String getZhiCheng() {
		return zhiCheng;
	}
	public void setCourseNames(String[] courseNames) {
		this.courseNames = courseNames;
	}
	public String[] getCourseNames() {
		return courseNames;
	}
	public static void main(String[] args) {
		Teacher p=new Teacher("z", "T1234","��", 20, 1);
		int age=p.getAge();
		int teaAge=p.getTeaAge();
		System.out.println(age+" "+teaAge);
	}
}

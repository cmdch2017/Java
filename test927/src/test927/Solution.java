package test927;
class Person implements Animal{
	private String id;
	private String name;
	private int sex;//1 为男生，0为女生
	private float height;
	private float weight;
	public String getId() {
		return id;
	}
	public Person() {
		
	}
	public void setId(String id) {
		if(id.length()!=18) { 
			System.out.println("身份证长度不满足18位");
			return;
		}
	    char id1=id.charAt(16);
	    int idsex=id1-'0';
	    //偶数是女生，如果不是偶数的话，说明不匹配，直接返还
	    if(idsex%2!=sex) {
	    	System.out.println("性别不匹配");
	    	return;
	    }
	    this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		if(sex==1) return "男";
		else if(sex==0) return "女";
		return "error";
	}
	public void setSex(int sex) {
		if(sex==1||sex==0)
		this.sex = sex;
		else {
			System.out.println("男生为1，女生为0");
		}
		return;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		if((1<height)&&(height<3))
		this.height = height;
	}
	@Override
	public void eat() {
		// TODO 自动生成的方法存根
		System.out.println("eat");
	}
	@Override
	public void sleep() {
		// TODO 自动生成的方法存根
		System.out.println("sleep");
	}
	public void setWeight(float weight) {
		this.weight=weight;
	}
	public float getWeight() {
		// TODO 自动生成的方法存根
		return weight;
	}
	}


public class Solution {
	public static void main(String[] mains) {
		Person o=new Person();
		o.setSex(1);
		o.setId("123456789012333339");
		o.setHeight(2);
		o.setWeight(60);
		o.setName("聪明");
		String id=o.getId();
		//System.out.println(id.length());
		String name=o.getName();
		float height=o.getHeight();
		String sex=o.getSex();
		float weight=o.getWeight();
		System.out.printf("姓名：%s 性别：%s 身高：%.2f米 身份证号：%s 体重：%.2fkg",name,sex,height,id,weight);
		System.out.println("");
		o.sleep();
		o.eat();
	}
}

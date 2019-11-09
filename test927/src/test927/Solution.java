package test927;
class Person implements Animal{
	private String id;
	private String name;
	private int sex;//1 Ϊ������0ΪŮ��
	private float height;
	private float weight;
	public String getId() {
		return id;
	}
	public Person() {
		
	}
	public void setId(String id) {
		if(id.length()!=18) { 
			System.out.println("���֤���Ȳ�����18λ");
			return;
		}
	    char id1=id.charAt(16);
	    int idsex=id1-'0';
	    //ż����Ů�����������ż���Ļ���˵����ƥ�䣬ֱ�ӷ���
	    if(idsex%2!=sex) {
	    	System.out.println("�Ա�ƥ��");
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
		if(sex==1) return "��";
		else if(sex==0) return "Ů";
		return "error";
	}
	public void setSex(int sex) {
		if(sex==1||sex==0)
		this.sex = sex;
		else {
			System.out.println("����Ϊ1��Ů��Ϊ0");
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
		// TODO �Զ����ɵķ������
		System.out.println("eat");
	}
	@Override
	public void sleep() {
		// TODO �Զ����ɵķ������
		System.out.println("sleep");
	}
	public void setWeight(float weight) {
		this.weight=weight;
	}
	public float getWeight() {
		// TODO �Զ����ɵķ������
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
		o.setName("����");
		String id=o.getId();
		//System.out.println(id.length());
		String name=o.getName();
		float height=o.getHeight();
		String sex=o.getSex();
		float weight=o.getWeight();
		System.out.printf("������%s �Ա�%s ��ߣ�%.2f�� ���֤�ţ�%s ���أ�%.2fkg",name,sex,height,id,weight);
		System.out.println("");
		o.sleep();
		o.eat();
	}
}

package test_107;
public class Test1 {
	public static void main(String[] args) {
	    Human human=new Human("С��","Ů","2017", 1, 60.8f);
	    print(human);
	}
	private static void print(Human holiday) {
		// TODO �Զ����ɵķ������
		System.out.println(holiday.getWeight()+" "+holiday.getHeight()+" "+holiday.getAge()+" "+holiday.getName()+" "+holiday.getSex());
	}
}

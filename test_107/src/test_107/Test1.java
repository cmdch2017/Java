package test_107;
public class Test1 {
	public static void main(String[] args) {
	    Human human=new Human("小红","女","2017", 1, 60.8f);
	    print(human);
	}
	private static void print(Human holiday) {
		// TODO 自动生成的方法存根
		System.out.println(holiday.getWeight()+" "+holiday.getHeight()+" "+holiday.getAge()+" "+holiday.getName()+" "+holiday.getSex());
	}
}

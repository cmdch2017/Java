package test_929;

public class Test1 {
	public static void main(String[] args) throws Exception {
	    HumanBeings human=new HumanBeings("叶子","女","612241998406442668",2.0f,100.2f);
	    human.chifan();
	    human.shuijiao();
	    print(human);
	    System.out.println("---------------");
	    HumanBeings holiday=new HumanBeings("张三","女","612241998406443256",2.0f,100.2f);
	    print(holiday);
	}

	private static void print(HumanBeings holiday) {
		// TODO 自动生成的方法存根
		System.out.println(holiday.getheight()+" "+holiday.getid()+" "+holiday.getname()+" "+holiday.getsex());
	}
	    	

}

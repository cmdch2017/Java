package test_1023;

public class Demo16 {
	public static void main(String[] args) {
		Count myCount=new Count();
		int times=0;
		for(int i=0;i<100;i++) {
			increment(myCount,times);
			System.out.println(myCount.count+" "+times);
		}
	}

	private static void increment(Count C, int times) {
		// TODO 自动生成的方法存根
		C.count++;
		times++;
	}
}

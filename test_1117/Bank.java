package test_1117;

public class Bank {
	public static void main(String[] args) throws Exception {
		//资源数
		int[] source= {10,5,7};
		//max（A、B、C）+Allocation +Need 
		int[][] array= {{7,5,3,0,1,0},
				        {3,2,2,2,0,0},
				        {3,2,2,2,0,0}};
		int[][] need= {{7,4,3},{1,2,2},{1,2,2}};
		int AL=array.length;//2
		int SL=source.length;//3
		int[] sum=new int[SL];
		for(int j=SL;j<2*SL;j++) {
		for(int i=0;i<AL;i++) {
			sum[j-SL]+=array[i][j];
		}
		}
		int[] Available=new int[SL];
		for(int i=0;i<SL;i++) {
			Available[i]=source[i]-sum[i];
		}
		//可用资源打印
		for(int i:Available) {
			System.out.println(i);
		}
		int canBeUsed=Usable(Available,need,AL,SL);
		if(canBeUsed==-1) {
			throw new Exception("分配error");
		}
		else {
		}
	}

	private static int Usable(int[] available, int[][] need, int aL, int sL) {
		// TODO 自动生成的方法存根
		return -1;
	}


}

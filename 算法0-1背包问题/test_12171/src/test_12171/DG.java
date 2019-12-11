package test_12171;
//递归O（2^n）
public class DG {
	public static void main(String[] args) {
		int n=3;//物品数
		int weight[] = new int[n];
		int value[] = new int[n];
		int sumWeight=0;
		for(int i=0;i<n;i++) {
			weight[i]=(int) (Math.random()*10+1);//重量设定为1-10
			sumWeight+=weight[i];
			value[i]=(int)(Math.random()*100+1);//价值设定成1-100
		}
	
	int W=sumWeight*2/3;//背包容量
	System.out.println("最大背包容量 "+W);
	System.out.print("max ");
	System.out.println(Knap(W,weight,value,n));
	test(weight,value);
	}

	private static void test(int[] weight, int[] value) {
		// TODO 自动生成的方法存根
		System.out.print("weight: ");
		for(int i:weight) {
			System.out.print(i+"  ");
		}
		System.out.println("");
		System.out.print("value:  ");
		for(int i:value) {
			System.out.print(i+" ");
		}
	}

	private static int Knap(int w, int[] wt, int[] val, int n) {
		// TODO 自动生成的方法存根
		if(w==0||n==0) {
			return 0;
		}
		//递归的时候特别要注意约束条件
		//你想每一次增加一个新的物品，如果超出背包容量，就让它递归回去
		if(wt[n-1]>w)
			return Knap(w,wt,val,n-1);
		return Math.max(Knap(w, wt,val,n-1),Knap(w-wt[n-1],wt,val,n-1)+val[n-1]);
	}
}

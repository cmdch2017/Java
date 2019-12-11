package test_12171;
public class FZXJ {
    public static void main(String[] args) {
    	int xunhuan=10;
    	while(xunhuan>0) {
    	int n=10;//ÎïÆ·Êı
		int sumWeight=0;
		 Knapsack[] bags = new Knapsack[n];
		for(int i=0;i<n;i++) {
			int key=(int) (Math.random()*10+1);
			sumWeight+=key;
			int value=(int)(Math.random()*100+1);
			bags[i]=new Knapsack(key,value);
		}
        int totalWeight = sumWeight*2/3;
        long a=System.nanoTime();
        FZXJProblem problem = new FZXJProblem(bags, totalWeight);
        problem.solve();
        problem.getBestValue();
        long b=System.nanoTime();
        System.out.print(b-a+" ");
        xunhuan--;
    }
    }

}

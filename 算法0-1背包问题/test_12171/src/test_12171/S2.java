
package test_12171;

 

//0-1��������

public class S2 {

	

	public static int knapsack(int[] weight, int[] value, int maxweight){

 

		int n = weight.length;

		//����ֵ����Ϊmaxvalue[N+1][maxWeight+1]����Ϊ����Ҫ��0��ʼ����

		int[][] maxvalue = new int[n+1][maxweight + 1];

		

		//��������ƷΪ0ʱ����ֵΪ0

		for (int i = 0; i < maxweight + 1; i++) {

			maxvalue[0][i] = 0;

			

		}

		for (int i = 0; i < n + 1; i++) {

			maxvalue[i][0] = 0;

			

		}

		

		//i��ֻ��ǰi����Ʒ�������i��Ϊȡ��0�����Զ�Ӧ��weight��value���涼��i-1��λ�ã�      

		//j��������ȡ��������Ϊj

		//n����Ʒ����

		for (int i = 1; i <= n ; i++) {

			for (int j = 1; j <= maxweight; j++) {

				//��ǰ����ֵ���ڷ���һ��������ֵ

				maxvalue[i][j] = maxvalue[i-1][j];

				//�����ǰ��������С�������������ԷŽ�ȥ�����ó���Ķ����ٷŽ�ȥ

				if (weight[i-1] <= j) {

					//�Ƚϣ����������Ʒ�ļ�ֵ����

					//�������Ʒ�ļ�ֵ ���� ��ǰ�ܷŵ���������ȥ��ǰ��Ʒ����ʱȡǰi-1����Ʒʱ�Ķ�Ӧ����ʱ�����߼�ֵ��

					if(maxvalue[i-1][j - weight[i-1]] + value[i-1]>maxvalue[i-1][j]) {

						maxvalue[i][j] = maxvalue[i-1][j - weight[i-1]] + value[i-1];

					}

				}

			}

		}

		return maxvalue[n][maxweight];

	}
//��̬�滮��
	public static void main(String[] args) {
		int xunhuan=100;
		while(xunhuan>0) {
		int n=100;//��Ʒ��
		int weight[] = new int[n];
		int value[] = new int[n];
		int sumWeight=0;
		for(int i=0;i<n;i++) {
			weight[i]=(int) (Math.random()*10+1);
			sumWeight+=weight[i];
			value[i]=(int)(Math.random()*100+1);
		}
		int maxWeight=sumWeight*2/3;
		
		long a=System.nanoTime();
		knapsack(weight, value, maxWeight);
		//System.out.println(knapsack(weight, value, maxWeight));
		long b=System.nanoTime();
		System.out.print((b-a)+" ");
		xunhuan--;
		}
	}

 

}

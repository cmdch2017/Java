package test_12171;
//�ݹ�O��2^n��
public class DG {
	public static void main(String[] args) {
		int n=3;//��Ʒ��
		int weight[] = new int[n];
		int value[] = new int[n];
		int sumWeight=0;
		for(int i=0;i<n;i++) {
			weight[i]=(int) (Math.random()*10+1);//�����趨Ϊ1-10
			sumWeight+=weight[i];
			value[i]=(int)(Math.random()*100+1);//��ֵ�趨��1-100
		}
	
	int W=sumWeight*2/3;//��������
	System.out.println("��󱳰����� "+W);
	System.out.print("max ");
	System.out.println(Knap(W,weight,value,n));
	test(weight,value);
	}

	private static void test(int[] weight, int[] value) {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		if(w==0||n==0) {
			return 0;
		}
		//�ݹ��ʱ���ر�Ҫע��Լ������
		//����ÿһ������һ���µ���Ʒ��������������������������ݹ��ȥ
		if(wt[n-1]>w)
			return Knap(w,wt,val,n-1);
		return Math.max(Knap(w, wt,val,n-1),Knap(w-wt[n-1],wt,val,n-1)+val[n-1]);
	}
}

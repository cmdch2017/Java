package test_12171;
//�����㷨
public class S3 {
private static int[] p;//��Ʒ�ļ�ֵ����
private static int[] w;//��Ʒ����������
private static int c;//�������õ�����
private static int count;//��Ʒ�ĸ���

private static int cw;//��ǰ������
private static int cp;//��ǰ�ļ�ֵ
static int bestp;//Ŀǰ����װ�صļ�ֵ
private static int r;//ʣ����Ʒ�ļ�ֵ

private static int[] cx;//��ŵ�ǰ��
private static int[] bestx;//������ս�

public static int Loading(int[] ww,int[] pp, int cc) {
    //��ʼ�����ݳ�Ա�������±��1��ʼ
    count = ww.length - 1;
    w = ww;
    p = pp;
    c = cc;
    cw = 0;
    bestp = 0;
    cx = new int[count+1];
    bestx = new int [count+1];

    //��ʼ��r����ʣ�����۸�
    for(int i = 1;i<=count;i++) {
        r += p[i];
    }

    //���û��ݷ�����
    BackTrack(1);
    return bestp;   
}

/**
 * ����
 * @param t
 */
public static void BackTrack(int t) {
    if(t>count) {//����Ҷ���
        if(cp>bestp) {
            for(int i = 1;i<=count;i++) {
                bestx[i] = cx[i];
            }

            bestp = cp;
        }
        return;
    }

    r -= p[t];
    if(cw + w[t] <= c) {//����������
        cx[t] = 1;
        cp += p[t];
        cw += w[t];
        BackTrack(t+1);
        cp -= p[t];//�ָ��ֳ�
        cw -= w[t];//�ָ��ֳ�

    }

    if(cp + r >bestp) {//��֦����
        cx[t] = 0;//����������
        BackTrack(t+1);
    }
    r += p[t];//�ָ��ֳ�
}



public static void main(String[] args) {
    //����
    int xunhuan=11;
	while(xunhuan>0) {
	int n=30;//��Ʒ��
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
	Loading(weight, value, maxWeight);
	long b=System.nanoTime();
	System.out.print((b-a)+" ");
	xunhuan--;
	}       
}
}

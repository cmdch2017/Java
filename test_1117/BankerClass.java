package test_1117;

import java.util.Scanner;

public class BankerClass {

    int[] Available = {10, 8, 7};
    int[][] Max = new int[3][3];
    int[][] Allocation = new int[3][3];
    int[][] Need = new int[3][3];
    int[][] Request = new int[3][3];
    int[] Work = new int[3];

    int num = 0;//���̱��
    Scanner in = new Scanner(System.in);

    public BankerClass() {
    }
    public void setSystemVariable(){//���ø���ʼϵͳ���������ж��Ƿ��ڰ�ȫ״̬��
        setMax();
        setAlloction();
        printSystemVariable();
        SecurityAlgorithm();
    }

    public void setMax() {//����Max����
        System.out.println("�����ø����̵�����������Max��");
        for (int i = 0; i < 3; i++) {
            System.out.println("���������P" + i + "�������Դ��������");
            for (int j = 0; j < 3; j++) {
                Max[i][j] = in.nextInt();
            }
        }
    }

    public void setAlloction() {//�����ѷ������Alloction
        System.out.println("input each Alloction��");
        for (int i = 0; i < 3; i++) {
            System.out.println("input P" + i + "�ķ�����Դ����");
            for (int j = 0; j < 3; j++) {
                Allocation[i][j] = in.nextInt();
            }
        }
        System.out.println("Available=Available-Alloction.");
        System.out.println("Need=Max-Alloction.");
        for (int i = 0; i < 3; i++) {//����Alloction����
            for (int j = 0; j < 3; j++) {
                Available[i] = Available[i] - Allocation[j][i];
            }
        }
        for (int i = 0; i < 3; i++) {//����Need����
            for (int j = 0; j < 3; j++) {
                Need[i][j] = Max[i][j] - Allocation[i][j];
            }
        }
    }

    public void printSystemVariable(){
        System.out.println("��ʱ��Դ���������£�");
        System.out.println("����  "+"   Max   "+"   Alloction "+"    Need  "+"     Available ");
        for(int i=0;i<3;i++){
            System.out.print("P"+i+"  ");
            for(int j=0;j<3;j++){
               System.out.print(Max[i][j]+"  "); 
            }
            System.out.print("|  ");
            for(int j=0;j<3;j++){
               System.out.print(Allocation[i][j]+"  "); 
            }
            System.out.print("|  ");
            for(int j=0;j<3;j++){
               System.out.print(Need[i][j]+"  "); 
            }
            System.out.print("|  ");
            if(i==0){
                for(int j=0;j<3;j++){
                    System.out.print(Available[j]+"  ");
                }
            }
            System.out.println();
        }
    }

    public void setRequest() {//����������Դ��Request


        System.out.println("������������Դ�Ľ��̱�ţ�");
        num= in.nextInt();//����ȫ�ֱ������̱��num
        System.out.println("�������������Դ��������");
        for (int j = 0; j < 3; j++) {
            Request[num][j] = in.nextInt();
        }
        System.out.println("������P" + num + "�Ը���Դ����Request��(" + Request[num][0] + "," + Request[num][1] + "," + Request[num][2] + ").");

        BankerAlgorithm();
    }

    public void BankerAlgorithm() {//���м��㷨
        boolean T=true;

        if (Request[num][0] <= Need[num][0] && Request[num][1] <= Need[num][1] && Request[num][2] <= Need[num][2]) {//�ж�Request�Ƿ�С��Need
            if (Request[num][0] <= Available[0] && Request[num][1] <= Available[1] && Request[num][2] <= Available[2]) {//�ж�Request�Ƿ�С��Alloction
                for (int i = 0; i < 3; i++) {
                    Available[i] -= Request[num][i];
                    Allocation[num][i] += Request[num][i];
                    Need[num][i] -= Request[num][i];
                }

            } else {
                System.out.println("��ǰû���㹻����Դ�ɷ��䣬����P" + num + "��ȴ���");
               T=false;
            }
        } else {
            System.out.println("����P" + num + "�����Ѿ��������������Need.");
            T=false;
        }

       if(T==true){
        printSystemVariable(); 
        System.out.println("���ڽ��밲ȫ�㷨��");
        SecurityAlgorithm();
       }
    }


    public void SecurityAlgorithm() {//��ȫ�㷨
        boolean[] Finish = {false, false, false};//��ʼ��Finish
        int count = 0;//��ɽ�����
        int circle=0;//ѭ��Ȧ��
        int[] S=new int[3];//��ȫ����
        for (int i = 0; i < 3; i++) {//���ù�������
            Work[i] = Available[i];
        }
        boolean flag = true;
        while (count < 3) {
            if(flag){
                System.out.println("����  "+"   Work  "+"   Alloction "+"    Need  "+"     Work+Alloction ");
                flag = false;
            }
            for (int i = 0; i < 3; i++) {

                if (Finish[i]==false&&Need[i][0]<=Work[0]&&Need[i][1]<=Work[1]&&Need[i][2]<=Work[2]) {//�ж�����
                    System.out.print("P"+i+"  ");
                    for (int k = 0; k < 3; k++){
                        System.out.print(Work[k]+"  ");
                    }
                    System.out.print("|  ");
                    for (int j = 0; j<3;j++){
                    Work[j]+=Allocation[i][j];
                    }
                    Finish[i]=true;//����ǰ����������ʱ
                    S[count]=i;//���õ�ǰ�����ź�

                    count++;//�����������1
                    for(int j=0;j<3;j++){
                       System.out.print(Allocation[i][j]+"  "); 
                    }
                    System.out.print("|  ");
                    for(int j=0;j<3;j++){
                       System.out.print(Need[i][j]+"  "); 
                    }
                    System.out.print("|  ");
                    for(int j=0;j<3;j++){
                       System.out.print(Work[j]+"  "); 
                    }
                    System.out.println();
                }

            }
            circle++;//ѭ��Ȧ����1

            if(count==3){//�ж��Ƿ��������н�����Ҫ
                System.out.print("��ʱ����һ����ȫ���У�");
                for (int i = 0; i<3;i++){//�����ȫ����
                    System.out.print("P"+S[i]+" ");
                }
                System.out.println("�ʵ�ǰ�ɷ��䣡");
                break;//����ѭ��
            }
            if(count<circle){//�ж���ɽ������Ƿ�С��ѭ��Ȧ��
                count=5;
                System.out.println("��ǰϵͳ���ڲ���ȫ״̬���ʲ����ڰ�ȫ���С�");
                break;//����ѭ��
            }
        }
    }

}

package class0519;
class Group{
	//����
	String name;//����
	int num;//����

	//����
	//���췽��
Group (String n,int m){
	name=n;
	num=m;
}
Group(String n){//����ʱ��String n��ʾ���������
	//ֻ����һ��string����ִ�д˺���
	name=n;
}
void print(String welcome) {
	System.out.printf("%s %s �� %d λͬѧ��%n",
			welcome,//�β�
			name,//����
			num//����
			);
	}
}
class B {
	int sum;
	B(int a,int b,int c){
		System.out.println(a+b+c);
		sum=a+b+c;
	}

void print() {
	System.out.println(sum);}
}

public class classGroup{
public static void main(String[] args) {
	B b=new B(1,2,3);
	b.print();
	Group group=new Group("java10��",50);
	group.print("��ӭ��������");
}
}

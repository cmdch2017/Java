package a;
class Node {
	int val;
	Node next;
   public Node(int val){
		this.val=val;
	}
}
public class solution {
public Node reverse(Node head) {
Node pre=null;
Node next=null;
while(head!=null) {
  next=head.next;
  head.next=pre;
  pre=head;
  head=next;
}
return pre;
}
public void display2(Node head) {
	for(Node cur=head;cur!=null;cur=cur.next) {
	System.out.println(cur.val);
	}
}
public void display(Node head) {
	Node cur=head;
	while(cur!=null) {
		System.out.print(cur.val+" ");
		cur=cur.next;
	}
	System.out.println("");
}
public static void main(String args[]) {
int row=9;
for(int i=1;i<=row;i++) {
	for(int j=1;j<=i;j++) {
		System.out.printf("%d*%d=%2d ",i,j,i*j);
	}
	System.out.println("");
}
solution List=new solution();
Node n1=new Node(1);
Node n2=new Node(2);
Node n3=new Node(5);
n1.next=n2;
n2.next=n3;
Node head=List.reverse(n1);
List.display(head);//����һ������ű����÷���
//List.display2(head);
//error    �����ֱ����display(n1);
//ֱ�����÷��������Ǿ�̬��
}
}

/*
 * ����
 * public class A{
 * ��Ա����      ����Ա������
 * public void method(){
 * ��������
 * ����������⣬�������ڷ��������в��ܳ��֣���System.out.println
 * }
 *}
 *class animal{}
 *class dog extends animal{}
 *�����ȷ��������
 *animal a=new animal();
 *dog b=new dog();
 *��̬����
 animal ab=new dog();
 ��ô�����������أ���ʵ�����ô�Ĵ洢�ռ�ȥ�洢��û������뵽�ľ���double a=6;
 �㱾��������4���ֽڵ�int��ʽ����Ҫ��8���ֽڴ洢Ҳ���԰�
 //����������
 interface IC{}
 class C implements IC{}//�ӿھ�����ҵ�뱸��¼�Ĺ�ϵ������¼�������븸���������ϵ�еĸ���
 IC ic=new C();
 ���һ�����ֶ�̬�ģ��������͵�����
 Object[] array=new String[10];
 
 ��������������
 ջ��������βκ;ֲ�����
 ������������� 
 ջ���������ȵ���main-��a-��b->c
 main
 a
 b
 c
 public class A{
 public static void c(){}
 public static void b(){c();}
 public static void a(){b();}
 public static void main(String[] args){
 a[];
 }
 }
 
�ؼ���instanceof ����һ��bool�����жϼ̳��е������ʵ���Ƿ�Ϊ�����ʵ��

�����Ķ����﷨
���ԣ����η�����������(������������)����������Ĭ��ֵ
����          ������������                       Сд��ͷ ��һ����������ĸ��д
��̬����   ������������                             int countOfArray
��1�����ڴ���Ϊ�����������һ������
��2���ñ�����������������
������
��˼���ռ��ϣ��������͸����������Ч�ķ�Χ��scope��
�����򣺿ռ��ϵ�//��̬��
�������ڣ�ʱ���ϵ�//��̬��

staticֻ�ܳ����ڳ�Ա����
static�Ͷ�����н��
����Ϊ��1����̬����
��2����̬����
��3����̬
 */
/*
 * class Outter{
 * class Inner{}
 * static class StaticInner{}
 * }
 * new Outter.StaticInner();
 * new Outter().new Inner();
 */

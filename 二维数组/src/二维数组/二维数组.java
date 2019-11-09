package 二维数组;

public class 二维数组 {
public static void main(String[] args) {
	int[][]arr=new int[3][];
	arr[0]=new int[] {11,12};
	arr[1]=new int[] {21,22,23};
	arr[2]=new int[] {31,32,33,34};
	int sum=0;
	for(int i=0;i<arr.length;i++) {
		int groupSum=0;
		for(int j=0;j<arr[i].length;j++) {
			groupSum=groupSum+arr[i][j];
			//System.out.println(arr[i][j]);
		}
		sum=sum+groupSum;
		System.out.println("第"+(i+1)+"小组销售额为："+groupSum+"万元");
	}
	System.out.println("总销售额为"+sum+"万元");
}
}
/*
 数组（arrays）
 1.语法
 定义数组，初始化数据
 2.内存模型
 遇到的第一个引用类型
 
 数组的初始化
 静态的方式
 1.静态的初始化
 int[] array={1,2,3,4,5};
 int[] array=new int[]={1,2,3,4,5};
 public class Course{
 public static void initArray(){
 printArray(new int[]{1,2,3,4,5});
 int []array=null;
 array=new int[]10;
 }
 2.动态的方式
 int[] array=new int[数组的长度];
 3.不初始化数组，指定一个NULL
 int[] array=null;//null是空引用
 
 数组的下标访问，用中括号[]制定具体的下标
 1.下标的类型一定是int
 2.下标的取值范围是，数组的长度是n个，则[0,n-1]
 }
 
 数组本质上是引用类型，是对象，和基本数据类型有很大区别
 1.int a=100;
 左边的空间，究竟存在什么位置
 1.内存
 2.栈 堆
 栈：1.局部变量 2.参数
 实参（arguments）与形参（paramaters）
 这里与c语言一样，所以直接就回顾一下c语言吧：
 void print(int a){
 System.out.println(a);//这里的a是paramaters
 }
 void main(){
 int a=10;print(a);这里的a是arguments
 }
 这里在栈中存放时有一个复制的过程，也就是说虽然值和名字都相同，但是分配的栈的空间不同
 结论：
 意味如果打印函数，最后的值一定为10，无论对形参如何赋值最后打印结果不变
  
  堆：引用的数据
 */
 
/*方法的定义（等同于c语言中的函数）
【限定符】返回值 函数名（参数列表）【异常声明】{方法体}
public static void main(String[] args) throws IOEXCEPTION{

}*
方法签名：方法名称+参数列表
通过签名唯一标识一个方法
1.重载（Overload）和重写（Override）不是一回事
2.递归函数
 1.在Java语法层面，递归方法没有特殊性
 2.如何更好的书写、理解递归方法
  书写：数学归纳法（局部性原则）
  1.递归公式
  n个的问题--》n-1的问题
  2.终止条件
  n==1
  方法调用栈（盗梦空间）
  先进后出的方式
  */
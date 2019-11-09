package WrapperString;
import java.util.Arrays;
/*
需求分析：字符串数值排序
观察： 字符串使用空格来对数值进行分割
主要问题：字符串不能比较数字大小
解决方案：将字符串数组转换成整型数组进行排序
优化：排序方法可以自己写个冒泡排序，快速排序等等，这里直接使用Arrays类中的sort()
方法将转换后的数组进行排序
完善：利用StringBuffer类的append()方法将数组元素和元素连接成字符串
 */
/*知识点：StringBuffer append()
 * 和 String 类不同的是，StringBuffer类的对象能够被多次的修改，
   并且不产生新的未使用对象
 * public class Test{
	  public static void main(String args[]){
	    StringBuffer sBuffer = new StringBuffer("欢迎一起学习：我是");
	    sBuffer.append("cmd");
	    sBuffers.append("c");
	    sBuffer.append("h");
	    System.out.println(sBuffer);  
	  }
	}
	输出结果：欢迎一起学习：我是cmdch
	*/
/*知识点：
 * 字符串赋值：String str = "abc";

is equivalent to: 

     char data[] = {'a', 'b', 'c'};
     String str = new String(data);
*/
public class WrapperString {
private static final String SPACE_SEPARATOR=" ";
public static void main(String[] args) {
	String numStr ="20 78 9 88 36 29";
	System.out.println(numStr);
	numStr=sortStringNumber(numStr);
	System.out.println(numStr.toString());
}
public static String sortStringNumber(String numStr) {
	//将字符串变成字符串数组
	String[] str_arr=stringToArray(numStr);
	//将字符串数组变成int数组
	int[] num_arr=toIntArray(str_arr);
	//对int数组进行排序
	mySortArray(num_arr);
	//将排序后的int数组变成字符串
	String temp=arrayToString(num_arr);
	return temp;
}
public static String arrayToString(int[] num_arr) {
	StringBuffer sb=new StringBuffer();
	for(int x=0;x<num_arr.length;x++) {
		if(x!=num_arr.length-1) {
			sb.append(num_arr[x]+SPACE_SEPARATOR);
		}
		else {
			sb.append(num_arr[x]);
		}
	}
	return sb.toString();
}
public static void mySortArray(int[] num_arr) {
	Arrays.sort(num_arr);
}
public static int[] toIntArray(String[] str_arr) {
	int[] arr=new int[str_arr.length];
	//表示申明一个整形一维数组arr，同时分配str_arr.length个整数大小的空间，
	//具体大小要看当前系统整形所占字节大小，一般是4个字节，所以4*10=40个字节
	for(int i=0;i<arr.length;i++) {
		arr[i]=Integer.parseInt(str_arr[i]);//return 参数以十进制返回的整数值
	}
	return arr;
}
public static String[] stringToArray(String numStr) {
	String[] str_arr=numStr.split(SPACE_SEPARATOR);
	/*
	 为了去掉空格的同时分离，这里使用了split函数
	 *类似于找一个参照字母或者符号，将它替换为分离符号的一种分离方法，
	 *特别注意的是结果数组中不包含尾随的空字符串
	这里是解释举个栗子
	The string "boo:and:foo", for example, yields the following results with these expressions: 

	Regex           Result

	:       { "boo", "and", "foo" }} 
	o       { "b", "", ":and:f" }} 
	*/ 

	return str_arr;
}
}

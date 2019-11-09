package WrapperString;
import java.util.Arrays;
/*
����������ַ�����ֵ����
�۲죺 �ַ���ʹ�ÿո�������ֵ���зָ�
��Ҫ���⣺�ַ������ܱȽ����ִ�С
������������ַ�������ת�������������������
�Ż������򷽷������Լ�д��ð�����򣬿�������ȵȣ�����ֱ��ʹ��Arrays���е�sort()
������ת����������������
���ƣ�����StringBuffer���append()����������Ԫ�غ�Ԫ�����ӳ��ַ���
 */
/*֪ʶ�㣺StringBuffer append()
 * �� String �಻ͬ���ǣ�StringBuffer��Ķ����ܹ�����ε��޸ģ�
   ���Ҳ������µ�δʹ�ö���
 * public class Test{
	  public static void main(String args[]){
	    StringBuffer sBuffer = new StringBuffer("��ӭһ��ѧϰ������");
	    sBuffer.append("cmd");
	    sBuffers.append("c");
	    sBuffer.append("h");
	    System.out.println(sBuffer);  
	  }
	}
	����������ӭһ��ѧϰ������cmdch
	*/
/*֪ʶ�㣺
 * �ַ�����ֵ��String str = "abc";

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
	//���ַ�������ַ�������
	String[] str_arr=stringToArray(numStr);
	//���ַ���������int����
	int[] num_arr=toIntArray(str_arr);
	//��int�����������
	mySortArray(num_arr);
	//��������int�������ַ���
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
	//��ʾ����һ������һά����arr��ͬʱ����str_arr.length��������С�Ŀռ䣬
	//�����СҪ����ǰϵͳ������ռ�ֽڴ�С��һ����4���ֽڣ�����4*10=40���ֽ�
	for(int i=0;i<arr.length;i++) {
		arr[i]=Integer.parseInt(str_arr[i]);//return ������ʮ���Ʒ��ص�����ֵ
	}
	return arr;
}
public static String[] stringToArray(String numStr) {
	String[] str_arr=numStr.split(SPACE_SEPARATOR);
	/*
	 Ϊ��ȥ���ո��ͬʱ���룬����ʹ����split����
	 *��������һ��������ĸ���߷��ţ������滻Ϊ������ŵ�һ�ַ��뷽����
	 *�ر�ע����ǽ�������в�����β��Ŀ��ַ���
	�����ǽ��;ٸ�����
	The string "boo:and:foo", for example, yields the following results with these expressions: 

	Regex           Result

	:       { "boo", "and", "foo" }} 
	o       { "b", "", ":and:f" }} 
	*/ 

	return str_arr;
}
}
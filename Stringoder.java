package Sringorder;
import java.lang.reflect.Array;
import java.util.Arrays;
public class Stringorder {//类名等于文件名
	private static final String SPACE_SEPARATOR=" ";
	public static void main(String[] args) {
		String numStr ="-7 20 78 9 88 -100 36 29";
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
		for(int i=0;i<num_arr.length;i++) {
			if(i!=num_arr.length-1) {
				sb.append(num_arr[i]+" ");
			}
			else
				sb.append(num_arr[i]);
		}
		return sb.toString();
		}
	public static void mySortArray(int[] num_arr) {
	     Arrays.sort(num_arr);
	}
	public static int[] toIntArray(String[] str_arr) {
	int[] arr=new int[str_arr.length];
	for(int i=0;i<arr.length;i++) {
		arr[i]=Integer.parseInt(str_arr[i]);
	}
	return arr;
	}
	public static String[] stringToArray(String numStr) {
		String[] str=numStr.split(SPACE_SEPARATOR);
		return str;
	}
}


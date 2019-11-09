package test_820;
import java.util.LinkedList;
import java.util.ArrayList;
//链表的方法使用
//顺序表的方法使用
public class Solution_2 {
public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<>();
		ArrayList<String> list2=new ArrayList<>();
		list.push("a");//栈
		list.push("b");
		list.addFirst("c");//头插
		System.out.println(list);//cba
		System.out.println(list.pollFirst());//c
		System.out.println(list);//ba
		System.out.println(list.pollLast());//a
		System.out.println(list);//b
		list2.add("a");
		list2.add("b");
		list2.remove("a");
		System.out.println(list2);//b
		boolean a=list.equals(list2);
		System.out.println(a);
		}
}

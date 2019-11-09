package test_819;
import java.util.ArrayList;
//泛型（嵌套与类型推导）
public class Main {
public static void main(String[] args) {
	//如果你不写<>,编译器会提示你
	//ArrayList 是原始类型。应该将对通用类型 ArrayList<E> 的引用参数化
	ArrayList<String> list=new ArrayList<>();
	//不用类型推导ArrayList<String> list=new ArrayList<String>();
	list.add("Hello"); //对象。
	list.add("World");
	System.out.println(list);
	Object L=list.clone();
	int location=list.indexOf("Hello");
	list.remove(location);
	System.out.println(list);
	System.out.println(L);
}
}

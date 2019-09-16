package classes;

import java.util.ArrayList;
import java.util.Iterator;


public class T {
	public static void main(String[] args) {
	ArrayList<String> list=new ArrayList<>();
	list.add("A");
	list.add("B");
	list.add("C");
	list.add("D");
	Iterator<String> it=list.iterator();
	while(it.hasNext()) {
		String s=it.next();
		if(s.equals("C")) {
			//System.out.println("É¾³ý³É¹¦");
			it.remove();
		}
	}
	Iterator<String> it2=list.iterator();
	while(it2.hasNext()) {
		System.out.println(it2.next());
	}
}
}

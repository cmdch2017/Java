package classes;

import java.util.ArrayList;
import java.util.Iterator;


public class T {
	public static void main(String[] args) {
		String idNum="62011220010908102X";
		String year=idNum.substring(6,10);
		String month=idNum.substring(10,12);
		String newMonth=month.replace("0", "");
		String day=idNum.substring(12,14);
		String newDay=day.replace("0", "");
		char a=idNum.charAt(16);
		String sex;
		int sexCheck=Integer.valueOf(a-'0')%2;
		if(sexCheck==0) {
			sex="��";
		}
		else {
			sex="Ů";
		}
		System.out.println("������"+year+"��"+newMonth+"��"+newDay+"��"+"������"+"��"+sex+"��");

	/*ArrayList<String> list=new ArrayList<>();
	list.add("A");
	list.add("B");
	list.add("C");
	list.add("D");
	Iterator<String> it=list.iterator();
	while(it.hasNext()) {
		String s=it.next();
		if(s.equals("C")) {
			//System.out.println("ɾ���ɹ�");
			it.remove();
		}
	}
	Iterator<String> it2=list.iterator();
	while(it2.hasNext()) {
		System.out.println(it2.next());
	}
	*/
}
}

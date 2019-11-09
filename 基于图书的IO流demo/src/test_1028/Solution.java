package test_1028;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
	FileReader fi=new FileReader("a1.txt");
	@SuppressWarnings("resource")
	BufferedReader br=new BufferedReader(fi);
	List <BookList> o=new ArrayList<>();
	while(br.read()!=0) {
	String str=br.readLine();
	if(str!=null) {
	String[] array=str.split(",");
	BookList l=new BookList(array[0],array[1],array[2],array[3],Double.parseDouble(array[4]),Integer.parseInt(array[5]));
	o.add(l);
	}
	else {
		break;
	}
	}
	menu();
	Scanner sc=new Scanner(System.in);
	int c=sc.nextInt();
	switch(c) {
	case 1:searchAll(o);break;
	case 2:publishSearch(o);break;
	case 3:ISBNSearch(o);break;
	case 4:countSatisfied(o);break;
		default:System.out.println("welcome"+"����������1��2��3��4");
	}
	}


	private static void menu() {
		// TODO �Զ����ɵķ������
		System.out.println("******welcome******");
		System.out.println("����������1��2��3��4");
		System.out.println("1.searchAll");
		System.out.println("2.publishSearch");
		System.out.println("3.ISBNSearch");
		System.out.println("4.countSatisfied");
	}



	private static void countSatisfied(List<BookList> o) {
		// TODO �Զ����ɵķ������
		System.out.println("���������������ҳ��");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		Actions.countSatisfied(o, i);
	}



	private static void ISBNSearch(List<BookList> o) throws Exception {
		// TODO �Զ����ɵķ������
		Scanner sc=new Scanner(System.in);
		System.out.println("������ISBN");
		String str=sc.nextLine();
		Actions.ISBNSearch(o,str);
	}



	private static void publishSearch(List<BookList> o) {
		// TODO �Զ����ɵķ������
		Scanner sc=new Scanner(System.in);
		System.out.println("�����������");
		String str=sc.nextLine();
		Actions.publishSearch(o,str);
	}



	private static void searchAll(List<BookList> o) {
		// TODO �Զ����ɵķ������
		Actions.searchAll(o);
	}



	
}

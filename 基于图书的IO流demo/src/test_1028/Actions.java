package test_1028;

import java.util.List;

public class Actions {
	public static void countSatisfied(List<BookList> o,int value) {
		// TODO �Զ����ɵķ������
		if(value<0) return;
		int count=0;
		for(BookList i:o) {
			if(i.getPages()>=value) {
				count++;
			}
			}
		System.out.println("ҳ����������"+value+" ���鼮����Ϊ"+count);
	}
	public static void publishSearch(List<BookList> o,String str) {
		// TODO �Զ����ɵķ������
		int countKinds=0;
		double totalPrice=0;
		for(BookList i:o) {
		if(i.getPublish().equals(str)) {
			countKinds++;
			totalPrice+=i.getPrice();
		}
		}
		if(countKinds==0) {
			try {
				throw new Exception("no such books");
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		System.out.println("���ݳ�����,�鼮���������� "+countKinds+"  �ܼ۸� "+totalPrice);
	}
	public static void ISBNSearch(List<BookList> o,String str) throws Exception {
		// TODO �Զ����ɵķ������
		Boolean count=false;
		for(BookList i:o) {
			if(i.getISBN().equals(str)) {
				System.out.println("������ "+i.getTitle()+"  ���ߣ� "+i.getAuthor()+"  ������"+i.getPublish());
				count=true;
			}
		}
		if(!count) {
			throw new Exception("no such ISBN");
		}
	}

	public static void searchAll(List<BookList> o) {
		// TODO �Զ����ɵķ������
		for(BookList i:o) {
			System.out.println(i.toString());
		}
	}
}

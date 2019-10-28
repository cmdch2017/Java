package test_1028;

import java.util.List;

public class Actions {
	public static void countSatisfied(List<BookList> o,int value) {
		// TODO 自动生成的方法存根
		if(value<0) return;
		int count=0;
		for(BookList i:o) {
			if(i.getPages()>=value) {
				count++;
			}
			}
		System.out.println("页码数不少于"+value+" ，书籍数量为"+count);
	}
	public static void publishSearch(List<BookList> o,String str) {
		// TODO 自动生成的方法存根
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println("根据出版社,书籍种类数量： "+countKinds+"  总价格 "+totalPrice);
	}
	public static void ISBNSearch(List<BookList> o,String str) throws Exception {
		// TODO 自动生成的方法存根
		Boolean count=false;
		for(BookList i:o) {
			if(i.getISBN().equals(str)) {
				System.out.println("书名： "+i.getTitle()+"  作者： "+i.getAuthor()+"  出版社"+i.getPublish());
				count=true;
			}
		}
		if(!count) {
			throw new Exception("no such ISBN");
		}
	}

	public static void searchAll(List<BookList> o) {
		// TODO 自动生成的方法存根
		for(BookList i:o) {
			System.out.println(i.toString());
		}
	}
}

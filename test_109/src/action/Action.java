package action;
import databases.BookShelf;
import exceptions.NoSuchBookException;
import test_109.Book;

public class Action {
	public static  Book putBook(String ISBN,String title,String author,Double price,int count) {
		//����ģʽ��ϵͳ�ڲ�ֻ����һ����ܶ���
		//BookShelf bookShelf=new BookShelf();
		BookShelf bookShelf=BookShelf.getInstance();
		try {
		Book book=bookShelf.search(ISBN);
		book.increaseCount(count);
		return book;
		}catch(NoSuchBookException exc) {
			Book book=new Book(ISBN,title,author,price,count);
			bookShelf.putBook(book);
			return book;
		}
		
	}

	
}

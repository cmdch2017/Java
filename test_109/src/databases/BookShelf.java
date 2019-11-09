package databases;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSuchBookException;
import test_109.Book;

public class BookShelf {
	private List<Book> bookList=new ArrayList<>();
	private static BookShelf instance=new BookShelf();
	public static BookShelf getInstance() {
		// TODO �Զ����ɵķ������
		return instance;
	}
	public Book search(String ISBN) throws NoSuchBookException {
		for(Book book:bookList) {
			if(book.match(ISBN)) {
				return book;
			}
		}
		throw new NoSuchBookException(ISBN);
	}
	public void putBook(Book book) {
		// TODO �Զ����ɵķ������
		bookList.add(book);
	}
}

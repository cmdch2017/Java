package databases;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSuchBookException;
import test_109.Book;

public class BookShelf {
	private List<Book> bookList=new ArrayList<>();
	private static BookShelf instance=new BookShelf();
	public static BookShelf getInstance() {
		// TODO 自动生成的方法存根
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
		// TODO 自动生成的方法存根
		bookList.add(book);
	}
}

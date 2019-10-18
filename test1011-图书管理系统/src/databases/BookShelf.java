package databases;

import classes.Book;
import exceptions.NoSuchBookException;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    // �����źܶ����
    // ��������ļ���
    private List<Book> bookList = new ArrayList<>();

    // ����ģʽ
    private static BookShelf instance = new BookShelf();
    public static BookShelf getInstance() {
        return instance;
    }

    public Book search(String ISBN) throws NoSuchBookException {
        for (Book book : bookList) {
            if (book.is(ISBN)) {
                return book;
            }
        }

        throw new NoSuchBookException(ISBN);
    }

    public void putBook(Book book) {
        bookList.add(book);
    }

    public List<Book> queryBooks(Where<Book> where) {
        List<Book> ret =  new ArrayList<>();
        for (Book book : bookList) {
            if (where == null || where.test(book)) {
                ret.add(book);
            }
        }

        return ret;
    }
}

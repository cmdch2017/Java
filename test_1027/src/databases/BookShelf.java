package databases;

import classes.Book;
import exceptions.NoSuchBookException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookShelf {
    // 保存着很多的书
    // 保存着书的集合
    private List<Book> bookList = new ArrayList<>();

    // 饿汉模式
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

    public List<Book> queryBooks(Where<Book> where, Comparator<Book> orderBy) {
        // SELECT
        List<Book> ret =  new ArrayList<>();
        for (Book book : bookList) {
            if (where == null || where.test(book)) {
                ret.add(book);
            }
        }

        if (orderBy != null) {
            ret.sort(orderBy);
        }

        return ret;
    }
}

package action;

import classes.Book;
import databases.BookShelf;
import exceptions.NoSuchBookException;

public class Action {
    /**
     * 图书上架
     * 1. 如果已经有了，增加数目(存量/总量)
     * 2. 如果没有，新书上架
     * @param ISBN
     * @param title
     * @param author
     * @param price
     * @param count
     * @return
     */
    public static Book putBook(String ISBN, String title, String author, double price, int count) {
        // 系统内部只能有一个书架对象
        // 单例模式
        BookShelf bookShelf = BookShelf.getInstance();
        try {
            Book book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;
        } catch (NoSuchBookException exc) {
            Book book = new Book(ISBN, title, author, price, count);
            bookShelf.putBook(book);
            return book;
        }
    }
}

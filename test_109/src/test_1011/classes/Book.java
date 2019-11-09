package classes;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    /**
     * 存量
     */
    private int currentCount;
    /**
     * 总量
     */
    private int totalCount;
    /**
     * 借阅次数
     */
    private int borrowedCount;

    public Book(String ISBN, String title, String author, double price, int count) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.currentCount = count;
        this.totalCount = count;
        this.borrowedCount = 0;
    }

    public boolean is(String ISBN) {
        return this.ISBN.equals(ISBN);
    }

    public void increaseCount(int count) {
        currentCount += count;
        totalCount += count;
    }

    public String getTitle() {
        return title;
    }
}

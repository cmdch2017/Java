package test_109;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private double price;
	private int currentCount;
	private int totalCount;
	private int borrowedCount;
	
	public Book(String ISBN, String title, String author, Double price, int count) {
		// TODO �Զ����ɵĹ��캯�����
		this.ISBN=ISBN;
		this.title=title;
		this.author=author;
		this.price=price;
		this.currentCount=count;
		this.totalCount=count;
		this.borrowedCount=0;
	}
	public boolean match(String ISBN) {
		// TODO �Զ����ɵķ������
		return this.ISBN.equals(ISBN);
	}
	public void increaseCount(int count) {
		// TODO �Զ����ɵķ������
		currentCount+=count;
		totalCount+=count;
	}
	
}

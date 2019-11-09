package homeWork;

public class Book {
	 private String ISBN;
	 private String title;
	 private String author;
	 private String publish;
	 private double price;
	 private int pages;
	 public Book(String ISBN, String title, String author, String publish, double price,int pages) {
	        this.setISBN(ISBN);
	        this.setTitle(title);
	        this.setAuthor(author);
	        this.setPrice(price);
	        this.setPublish(publish);
	        this.setPages(pages);
	    }
	 public Book() { }
	 public String toString() {
			return "BookList [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", price=" + price
					+ ", publish=" + publish + ", pages=" + pages + "]";
		}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
}

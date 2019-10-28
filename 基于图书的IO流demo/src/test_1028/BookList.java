package test_1028;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BookList {
	    private String ISBN;
	    private String title;
	    private String author;
	    private double price;
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
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getPublish() {
			return publish;
		}
		public void setPublish(String publish) {
			this.publish = publish;
		}
		public int getPages() {
			return pages;
		}
		public void setPages(int pages) {
			this.pages = pages;
		}
		@Override
		public String toString() {
			return "BookList [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", price=" + price
					+ ", publish=" + publish + ", pages=" + pages + "]";
		}
		private String publish;
		private int pages;
	    public BookList(String ISBN, String title, String author, String publish, double price,int pages) {
	        this.ISBN = ISBN;
	        this.title = title;
	        this.author = author;
	        this.price = price;
	        this.publish=publish;
	        this.pages=pages;
	    }
	    public BookList() {
			// TODO 自动生成的构造函数存根
		}
}
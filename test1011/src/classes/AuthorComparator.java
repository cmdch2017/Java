package classes;

import java.util.Collections;

public class AuthorComparator implements Comparable<Book>{

	@Override
	public int compareTo(Book o) {
		// TODO 自动生成的方法存根
	
		return Integer.parseInt(o.getAuthor())-Integer.parseInt(this.toString());
	}
	
}

package classes;

import java.util.Collections;

public class AuthorComparator implements Comparable<Book>{

	@Override
	public int compareTo(Book o) {
		// TODO �Զ����ɵķ������
	
		return Integer.parseInt(o.getAuthor())-Integer.parseInt(this.toString());
	}
	
}

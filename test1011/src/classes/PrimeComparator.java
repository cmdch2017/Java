package classes;

import java.util.Comparator;

public class PrimeComparator implements Comparator <Book>{
	public boolean asc;
	PrimeComparator(boolean asc){
		this.asc=asc;
	}
	@Override
	public int compare(Book o1, Book o2) {
		// TODO �Զ����ɵķ������
		if(asc)
		return (int) ((o1.getPrice())-(o2.getPrice()));
		return (int) ((o2.getPrice())-(o1.getPrice()));
	}
	
}

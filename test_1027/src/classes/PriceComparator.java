package classes;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book> {
    private boolean asc;    // 从小到大

    public PriceComparator(boolean asc) {
        this.asc = asc;
    }

    @Override
    public int compare(Book o1, Book o2) {
        if (asc) {
            return (int)((o1.getPrice() - o2.getPrice()) * 100);
        } else {
            return (int)((o2.getPrice() - o1.getPrice()) * 100);
        }
    }
}

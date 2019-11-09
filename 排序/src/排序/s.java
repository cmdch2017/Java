package 排序;
import java.util.Comparator;
public class s implements Comparable<s>{
int rank;
int suit;
@Override
public int compareTo(s o) {
	// TODO 自动生成的方法存根
	return rank-o.rank;
}
class Dou implements Comparator<s>{
	@Override
	public int compare(s o1, s o2) {
		// TODO 自动生成的方法存根
		return o1.suit-o2.suit;
	}
}
}


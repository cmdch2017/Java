package test_116;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int[] array= {1,3,5,4,2};
		Solution2 l=new Solution2();
		l.findKth(array,Array.getLength(array),2);
	}
    public  int findKth(int[] a, int n, int K) {
	int[] b=Arrays.copyOf(a, n);
	Arrays.sort(b);
    return b[b.length-K];
    }
}

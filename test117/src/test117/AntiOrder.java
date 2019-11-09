package test117;

import java.util.Arrays;

public class AntiOrder {
    public int count(int[] A, int n) {
        // write code here
    	int count=0;
    	int[] array=Arrays.copyOf(A, n);
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++) {
    			if(array[i]>array[j])
    				count++;
    		}
    	}
    	return count;
    }
    public static void main(String[] args) {
    	int[] array= {1,2,3,4,5,6,7,0};
    	//AntiOrder l=new AntiOrder();
    	//int key=l.count(array,8);
    	int count=0;
    	int n=8;
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++) {
    			if(array[i]>array[j])
    				count++;
    		}
    	}
    	System.out.println(count);
    }
}
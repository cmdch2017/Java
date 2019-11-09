package test_116;

public class Solution {
	public static void main(String[] args) {
		MyThread t=new MyThread();
		t.start();
		MyRunner l=new MyRunner();
		Thread t2=new Thread(l);
		t2.start();
		while(true) {
			
		}
	}
}


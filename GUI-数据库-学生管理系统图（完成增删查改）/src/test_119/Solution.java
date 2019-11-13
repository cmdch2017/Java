package test_119;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int key=sc.nextInt();
		int ret=bought(key);
		System.out.println(ret);
	}

	private static int bought(int key) {
		// TODO 自动生成的方法存根
		int ret=-1;
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				if(6*i+8*j==key) {
					return i+j;
				}
			}
		}
		return ret;
	}
}

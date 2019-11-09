package test_1023;

public class MyInteger6 {
	private int value;
	MyInteger6(int x){
		value=x;
	}
	public int getInt() {
		return value;
	}
	public boolean isEven() {
		return (value%2==0);
	}
	public boolean isOdd() {
		return ((value+1)%2==0);
	}
	public boolean vegetable() {
		if(value==1) return false;
		if(value==2) return true;
		for(int i=2;i<value/2;i++) {
			if(value%i==0) {
			return false;
			}
		}
		return true;
	}
	public boolean equals(int x) {
		return value==x;
	}
	public int parseInt(String x) {
		return Integer.parseInt(x);
	}
	public static void main(String[] args) {
		MyInteger6 l=new MyInteger6(6);
		System.out.println("l.getInt() "+l.getInt()+"  l.isEven() "+l.isEven()+
				"  l.isOdd() "+l.isOdd());
		System.out.println("l.vegetable() "+l.vegetable()+
				"  l.equals(6) "+l.equals(6)+"  l.parseInt(\"8\") "+l.parseInt("8"));
	}
}

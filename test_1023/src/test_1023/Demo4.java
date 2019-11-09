package test_1023;
class MyDate{
	private int y;
	private int m;
	private int d;
	String zero1="0";
	String zero2="0";
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public MyDate(int y, int m, int d) {
		super();
		this.y = y;
		this.m = m;
		this.d = d;
	}
	MyDate(){
		y=2008;
		m=1;
		d=1;
	}
	void showDate() {
		if(m>=10) zero1="";
		if(d>=10) zero2="";
		System.out.println(y+"Äê"+zero1+m+"ÔÂ"+zero2+d+"ÈÕ");
	}

}
public class Demo4 {
	public static void main(String[] args) {
		MyDate l=new MyDate(2009,10,1);
		l.showDate();
	}
}

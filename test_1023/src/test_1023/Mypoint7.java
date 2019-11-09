package test_1023;

public class Mypoint7 {
	private double x;
	private double y;
	Mypoint7(){
		x=0;
		y=0;
	}
	Mypoint7(double x,double y){
		this.x=x;
		this.y=y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public static void main(String[] args) {
		Mypoint7 l1=new Mypoint7(2,3);
		Mypoint7 l2=new Mypoint7(10,30.5);
		System.out.println(distance(l1,l2));
	}
	private static double distance(Mypoint7 l1, Mypoint7 l2) {
		// TODO 自动生成的方法存根
		double value=(l2.x-l1.x)*(l2.x-l1.x)-(l2.y-l1.y)*(l2.y-l1.y);
		if(value>0) return Math.sqrt(value);
		else {
			return Math.sqrt(-value);
		}
	}
}

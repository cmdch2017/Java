package test_1023;
class Rectangle{
	private double width=1.0;
	private double height=1.0;
	private String color="white";
	double Area;
	double Perimeter;
	public double getArea() {
		return width*height;
	}

	public double getPerimeter() {
		return 2*(width+height);
	}
	
	Rectangle(){
		
	}
	
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", color=" + color + "]";
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	Rectangle(double width,double height,String color){
		this.width=width;
		this.height=height;
		this.color=color;
	}
	
}
public class Demo5 {
	public static void main(String[] args) {
		Rectangle l=new Rectangle(4,40,"yellow");
		System.out.println(l.toString());
		System.out.println("perimeter: "+l.getPerimeter()+" area: "+l.getArea());
		Rectangle o=new Rectangle(3.5,35.9,"red");
		System.out.println(o.toString());
		System.out.println("perimeter: "+o.getPerimeter()+" area: "+o.getArea());
	}
}

package test117;
class Base{
	Base(){
		System.out.println("Base");
	}
}
public class Alpha extends Base {
	public static void main(String[] args) {
		new Alpha();
		new Base();
	}
}

package test117;

public class SystemUtil{
	public static boolean isAdmin(String userId) {
	return userId.toLowerCase()=="admin";
	}
	public static void main(String[] args) {
		String a="abc";
		String b="abc";
		System.out.println(a==b);
		System.out.println(isAdmin("Admin"));
	}
}

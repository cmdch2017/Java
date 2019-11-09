package test921;

import java.util.Arrays;

public class Solution implements Comparable<MyString>{
	private char[] value=null;
	public MyString toUpper() {
		MyString s=new MyString(value);
		for(char a:s.value) {
			if(a>='a'&&a<='z') {
				a=(char)(a-'a'+'A');
			}
		}
		return s;
	}
 //将字符数组中的所有内容变为字符串
	public void MyString(char value[]) {
	this.value=Arrays.copyOf(value, value.length);
	}
    public void MyString(char value[],int offset,int count) {
    	this.value=Arrays.copyOfRange(value, offset, offset);
    }
    public void MyString(MyString s) {
    	this.value=s.value;
    }
	public char charAt(int index) {
		return value[index];
	}
	public char[] toCharArray() {
		return Arrays.copyOf(value, value.length);
	}
	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(value);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solution other = (Solution) obj;
		if (!Arrays.equals(value, other.value))
			return false;
		return true;
	}
@Override
public int compareTo(test921.MyString o) {
	// TODO 自动生成的方法存根
	return 0;
}
public static void main(String[] args) {
	
}

}

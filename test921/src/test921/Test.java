package test921;
import java.util.Arrays;
public final class Test implements Comparable<Test> {
    private final char[] value;
    @Override
    public boolean equals(Object s) {
        if (this == s) {
            return true;
        }
        if (s == null) {
            return false;
        }
        // s.getClass() == getClass()
        if (!(s instanceof Test)) {
            return false;
        }

        return Arrays.equals(value, ((Test) s).value);
    }

    public Test(char value[]) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Test(char value[], int offset, int count) {
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

 
    public Test(Test s) {
        this.value = s.value;
    }

    
   /* public  MyString(boolean intern) {
    	return null;
    }

    public MyString intern() {
		return null;
    }
    */

    public char charAt(int index) {
        return value[index];
    }

    // 不能直接返回引用，防止引用泄�?
    public char[] toCharArray() {
        return Arrays.copyOf(value, value.length);
    }

    public Test toUpper() {
        Test s = new Test(value);
        for (int i = 0; i < s.value.length; i++) {
            if (s.value[i] >= 'a' && s.value[i] <= 'z') {
                s.value[i] = (char)(s.value[i] - 'a' + 'A');
            }
        }
        return s;
    }




    public boolean equalsIgnoreCase(Test s) {
        return toUpper().equals(s.toUpper());
    }

    public Test toLower() {
        Test s = new Test(value);
        for (int i = 0; i < s.value.length; i++) {
            if (s.value[i] >= 'a' && s.value[i] <= 'z') {
                s.value[i] = (char)(s.value[i] + 'a' - 'A');
            }
        }
        return s;
    }

    @Override
    public int hashCode() {
    	int hash=0;
    	for(char c:value) {
    		hash=(hash^c);
    	}
        return hash;
    }

    public MyString substring(int begin, int end) {
    	return new MyString(value,begin,end-begin);
    }

    @Override
    public int compareTo(Test o) {
        return 0;
    }

    @Override
    public String toString() {
        return new String(value);
    }

    public static void main(String[] args) {
        char[] a = { 'a', 'b', 'c' };
        Test s = new Test(a);
        Test t = new Test(s);
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));
        Test r = t.toUpper();
        System.out.println(s);
        System.out.println(t);
        System.out.println(r);
        System.out.println(s.equals(t));
        a[0] = 'z';
        System.out.println(s);
        System.out.println(t);
        System.out.println(r);
        System.out.println(s.equals(t));
    }
}

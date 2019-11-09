package mergesort;  

import java.text.DecimalFormat;  
import java.util.Random;  
  
public class Record {  
    private int A;  
      
    @Override  
    public String toString() {  
        String tempA = new  DecimalFormat("0000000000").format(this.A);  
        return tempA;  
    }  
      
    public String getRecordString(){  
        String A = new  DecimalFormat("0000000000").format(Math.abs( new Random().nextInt()));   
        return A;  
    }  
      
  
    public Record() {  
        super();  
    }  
  
    public Record(String line) {  
        super();  
        String [] t = line.split("#");  
        this.A = Integer.valueOf(t[0]);  
    }  
  
  
    public int getA() {  
        return A;  
    }  
  
  
    public void setA(int a) {  
        A = a;  
    }  

      
}  

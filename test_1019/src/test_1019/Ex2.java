package test_1019;
import java.io.*;
import java.util.Arrays;


public class Ex2 {
  public static void main(String[] args) throws IOException {
	  for(int i=1;i<=2;i++) {
      FileWriter fos = new FileWriter("a"+i+".txt");
      for(int j = 1; j <= 10000; j++) {
          int number = (int)(Math.random() * 10000);
         //System.out.println(number);
          fos.write(number);
      }       
      fos.close();
	  } 
	  int count=0;  
      FileReader fis = new FileReader("a"+1+".txt");
	  FileReader fiv = new FileReader("a"+2+".txt");
      int ch = 0;
      int[] array = new int[20000] ;
	   int ai=0;
      while((ch = fis.read()) != -1) {
    	// System.out.println(ch+" ");  
    		 array[ai++]=ch;
      }
      while((ch = fiv.read()) != -1) { 
     		 array[ai++]=ch;
       }
    	  Arrays.sort(array);
          fiv.close();
          FileWriter fos2 = new FileWriter("a"+1+".txt");
          for(int i:array) {
        	  fos2.write(i);
          }
          fos2.close();
          fis.close(); 
          FileReader fis2=new FileReader("a"+1+".txt");
          while((ch = fis2.read()) != -1) {
         	 System.out.println(ch);
         	 count++;
           }
          fis2.close();
         System.out.println(count);
	  }

  }

package test_929;



import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;

 
public class Test6 {

 

	public static void main(String[] args) throws Exception {

		File file=new File("D://1.txt");
		//��дreFile
		OutputStream outputStream=new FileOutputStream(file);
        //׷��add
		//OutputStream outputStream=new FileOutputStream(file,true);

		String str="hello World ����";

		byte[] b=str.getBytes();

		outputStream.write(b);

		outputStream.close();

	}

}

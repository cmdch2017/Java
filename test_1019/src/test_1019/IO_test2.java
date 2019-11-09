package test_1019;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO_test2 {
	public static void main(String[] args) throws IOException {
		System.out.println("请输入需要输入到文本的文字 ");
		FileWriter writer=new FileWriter("a1.txt");
		String str="helloWorld";
		writer.write(str);
		writer.close();
		FileReader reader=new FileReader("a1.txt");
		int ch;
		while((ch=reader.read())!=-1){
			System.out.println((char)ch);
		}
		reader.close();
		
	}
}

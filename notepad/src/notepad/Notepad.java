package notepad;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Notepad {
private static String filePath;
private static String message="";
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("1.新建文件 2.打开文件 3.修改文件 4.保存 5.退出");
	while(true) {
		System.out.print("请输入操作命令：");
		int command=sc.nextInt();
		switch(command) {
		case 1:createFile();
		break;
		case 2:openFile();
		break;
		case 3:editFile();
		break;
		case 4:saveFile();
		break;
		case 5:exit();
		break;
		default:
			System.out.println("您输入的指令错误");
			break;
		}//sc.close();
	}
	
}
private static void createFile() {
	message="";//新建文件时，暂存文件内容清空
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入内容，停止编写请输入\"stop\":");
	StringBuffer sb=new StringBuffer();
	String inputMessage="";
	//equals在没重写之前和==一样，重写后equals只要内容一样即为true
	//true if the given object represents a String equivalent to this string
	while(!inputMessage.equals("stop")) {//输入"stop"时，停止输入
		if(sb.length()>0) {
			//追加换行符
			sb.append("\r\n");
		}
		//拼接输入信息
		sb.append(inputMessage);
		inputMessage=sc.nextLine();
	}
	message=sb.toString();//将输入内容暂存
	//sc.close();
}
private static void openFile() throws Exception{
	message="";
	Scanner sc=new Scanner(System.in);
	System.out.print("请输入打开文件的位置：");
	filePath=sc.next();//获取打开文件的路径
	//控制只能输入txt格式的文件路径
	if(filePath!=null&&!filePath.endsWith(".txt")) {
		System.out.print("请选择文本文件！");
		return;
	}
	FileReader in=new FileReader(filePath);
	char[] charArray=new char[1024];//缓冲数组
	int len;
	//循环读取，一次读取一个字符数组
	StringBuffer sb=new StringBuffer();
while((len=in.read(charArray))!=-1) {
	sb.append(charArray);
}
message=sb.toString();
System.out.println("打开文件内容："+"\r\n"+message);
in.close();
}
private static void editFile() {
	if(message==""&&filePath==null) {
		System.out.println("请先新建文件或者打开文件");
		return ;
	}
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入要修改的内容（以\"修改的目标文字：修改之后的文字\"格式）,"+"停止修改请输入\"stop\":");
	String inputMessage="";
	while(!inputMessage.equals("stop")) {//输入stop时，停止修改
		inputMessage=sc.nextLine();
		if(inputMessage!=null&&inputMessage.length()>0) {
			String[] editMessage=inputMessage.split(":");
			if(editMessage!=null&&editMessage.length>1) {
				message=message.replace(editMessage[0],editMessage[1]);
			}
		}
	}
}
private static void saveFile() throws IOException {
	Scanner sc=new Scanner(System.in);
	FileWriter out=null;
	if(filePath!=null) {
		//将原文件覆盖
		out=new FileWriter(filePath);
	}
	//新建文件
	else {
		System.out.print("请输入文件保存的绝对路径：");
		String path=sc.nextLine();
		filePath=path;
		if(!filePath.toLowerCase().endsWith(".txt")) {
			filePath+=".txt";
		}
		//构造输出流
		out=new FileWriter(filePath);
	}
	//sc.close();
	out.write(message);
	out.close();
	message="";
	filePath=null;
}
private static void exit() {
	System.out.println("您已退出系统，谢谢使用");
}
}

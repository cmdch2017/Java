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
	System.out.println("1.�½��ļ� 2.���ļ� 3.�޸��ļ� 4.���� 5.�˳�");
	while(true) {
		System.out.print("������������");
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
			System.out.println("�������ָ�����");
			break;
		}//sc.close();
	}
	
}
private static void createFile() {
	message="";//�½��ļ�ʱ���ݴ��ļ��������
	Scanner sc=new Scanner(System.in);
	System.out.println("���������ݣ�ֹͣ��д������\"stop\":");
	StringBuffer sb=new StringBuffer();
	String inputMessage="";
	//equals��û��д֮ǰ��==һ������д��equalsֻҪ����һ����Ϊtrue
	//true if the given object represents a String equivalent to this string
	while(!inputMessage.equals("stop")) {//����"stop"ʱ��ֹͣ����
		if(sb.length()>0) {
			//׷�ӻ��з�
			sb.append("\r\n");
		}
		//ƴ��������Ϣ
		sb.append(inputMessage);
		inputMessage=sc.nextLine();
	}
	message=sb.toString();//�����������ݴ�
	//sc.close();
}
private static void openFile() throws Exception{
	message="";
	Scanner sc=new Scanner(System.in);
	System.out.print("��������ļ���λ�ã�");
	filePath=sc.next();//��ȡ���ļ���·��
	//����ֻ������txt��ʽ���ļ�·��
	if(filePath!=null&&!filePath.endsWith(".txt")) {
		System.out.print("��ѡ���ı��ļ���");
		return;
	}
	FileReader in=new FileReader(filePath);
	char[] charArray=new char[1024];//��������
	int len;
	//ѭ����ȡ��һ�ζ�ȡһ���ַ�����
	StringBuffer sb=new StringBuffer();
while((len=in.read(charArray))!=-1) {
	sb.append(charArray);
}
message=sb.toString();
System.out.println("���ļ����ݣ�"+"\r\n"+message);
in.close();
}
private static void editFile() {
	if(message==""&&filePath==null) {
		System.out.println("�����½��ļ����ߴ��ļ�");
		return ;
	}
	Scanner sc=new Scanner(System.in);
	System.out.println("������Ҫ�޸ĵ����ݣ���\"�޸ĵ�Ŀ�����֣��޸�֮�������\"��ʽ��,"+"ֹͣ�޸�������\"stop\":");
	String inputMessage="";
	while(!inputMessage.equals("stop")) {//����stopʱ��ֹͣ�޸�
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
		//��ԭ�ļ�����
		out=new FileWriter(filePath);
	}
	//�½��ļ�
	else {
		System.out.print("�������ļ�����ľ���·����");
		String path=sc.nextLine();
		filePath=path;
		if(!filePath.toLowerCase().endsWith(".txt")) {
			filePath+=".txt";
		}
		//���������
		out=new FileWriter(filePath);
	}
	//sc.close();
	out.write(message);
	out.close();
	message="";
	filePath=null;
}
private static void exit() {
	System.out.println("�����˳�ϵͳ��ллʹ��");
}
}

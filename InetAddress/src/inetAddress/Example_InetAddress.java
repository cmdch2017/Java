package inetAddress;
import java.net.InetAddress;
public class Example_InetAddress {
	//throws Exception��ʾ���Ǳ������������쳣�����������ô�����(����㲻ϣ���쳣��������ף����Ҫ��throws Exception) �����ұ����ô����봦��
public static void main(String[] args) throws Exception{
	InetAddress localAddress=InetAddress.getLocalHost();
	//����һ����ʾ����������InetAddress����
	InetAddress baiduAddress=InetAddress.getByName("www.baidu.com");
	//getByName(host)����host��ʶָ������
	//�÷��������ڸ����������������ȷ��������IP��ַ
	System.out.println("������IP��ַ:"+localAddress.getHostAddress());
	System.out.println("baidu��IP��ַ:"+baiduAddress.getHostAddress());
	System.out.println("3���Ƿ�ɴ�"+baiduAddress.isReachable(3000));
	int n=3000;
	for(int i=0;i<n;i++) {
		if(baiduAddress.isReachable(i)) {
			System.out.println("����ٶȵ�IP��ַʱ��:"+i+"����");
			break;
		}
	}
	System.out.println("baidu��������:"+baiduAddress.getHostName());
}
}
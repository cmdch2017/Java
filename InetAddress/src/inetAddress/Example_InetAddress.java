package inetAddress;
import java.net.InetAddress;
public class Example_InetAddress {
	//throws Exception表示的是本方法不处理异常，交给被调用处处理(如果你不希望异常层层往上抛，你就要用throws Exception) ，而且被调用处必须处理
public static void main(String[] args) throws Exception{
	InetAddress localAddress=InetAddress.getLocalHost();
	//创建一个表示本地主机的InetAddress对象
	InetAddress baiduAddress=InetAddress.getByName("www.baidu.com");
	//getByName(host)参数host标识指定的主
	//该方法用于在给定主机名的情况下确定主机的IP地址
	System.out.println("本机的IP地址:"+localAddress.getHostAddress());
	System.out.println("baidu的IP地址:"+baiduAddress.getHostAddress());
	System.out.println("3秒是否可达"+baiduAddress.isReachable(3000));
	int n=3000;
	for(int i=0;i<n;i++) {
		if(baiduAddress.isReachable(i)) {
			System.out.println("到达百度的IP地址时间:"+i+"毫秒");
			break;
		}
	}
	System.out.println("baidu的主机名:"+baiduAddress.getHostName());
}
}
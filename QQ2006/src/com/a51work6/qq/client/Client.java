/*
* Created by 智捷课堂
* 本书网站：http://www.zhijieketang.com/group/5
* 智捷课堂在线课堂：www.zhijieketang.com
* 智捷课堂微信公共号：zhijieketang
* 邮箱：eorient@sina.com
* Java读者服务QQ群：547370999
*
* 买《Java从小白到大牛》纸质版图书，送配套视频
*
* 【配套电子书】网址：
*       图灵社区：
*       http://www.ituring.com.cn/book/2480
*       百度阅读：
*       https://yuedu.baidu.com/ebook/7c1499987e192279168884868762caaedd33ba00 
*/


package com.a51work6.qq.client;

import java.io.IOException;
import java.net.DatagramSocket;

public class Client {

	// 命令代码
	public static final int COMMAND_LOGIN = 1; // 登录命令
	public static final int COMMAND_LOGOUT = 2; // 注销命令
	public static final int COMMAND_SENDMSG = 3; // 发消息命令

	public static DatagramSocket socket;
	// 服务器端IP
	public static String SERVER_IP = "127.0.0.1";
	// 服务器端端口号
	public static int SERVER_PORT = 3366;

	public static void main(String[] args) {

		if (args.length == 2) {
			SERVER_IP = args[0];
			SERVER_PORT = Integer.parseInt(args[1]);
		}

		try {// 创建DatagramSocket对象，由系统分配可以使用的端口
			socket = new DatagramSocket();
			// 设置超时5秒，不再等待接收数据
			socket.setSoTimeout(5000);
			System.out.println("客户端运行...");
			LoginFrame frame = new LoginFrame();
			frame.setVisible(true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

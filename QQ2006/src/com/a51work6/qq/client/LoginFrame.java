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

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONObject;

public class LoginFrame extends JFrame {

	// private Client client;
	// 获得当前屏幕的宽和高
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	// 登录窗口宽和高
	private int frameWidth = 329;
	private int frameHeight = 250;

	// QQ号码文本框
	private JTextField txtUserId = null;
	// QQ密码框
	private JPasswordField txtUserPwd = null;

	public LoginFrame() {

		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon(LoginFrame.class.getResource("/resource/img/QQll.JPG")));
		lblImage.setBounds(0, 0, 325, 48);
		getContentPane().add(lblImage);

		// 添加蓝线面板
		getContentPane().add(getPaneLine());

		// 初始化登录按钮
		JButton btnLogin = new JButton();
		btnLogin.setBounds(152, 181, 63, 19);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLogin.setText("登录");
		getContentPane().add(btnLogin);
		// 注册登录按钮事件监听器
		btnLogin.addActionListener(e -> {

			// 先进行用户输入验证，验证通过再登录
			String userId = txtUserId.getText();
			String password = new String(txtUserPwd.getPassword());
		
			Map user = login(userId, password);
			if (user != null) {
				// 登录成功调转界面
				System.out.println("登录成功调转界面");
				// 设置登录窗口可见
				this.setVisible(false);
				FriendsFrame frame = new FriendsFrame(user);
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "您QQ号码或密码不正确");
			}

		});

		// 初始化取消按钮
		JButton btnCancel = new JButton();
		btnCancel.setBounds(233, 181, 63, 19);
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCancel.setText("取消");
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(e -> {
			// 退出系统
			System.exit(0);
		});

		// 初始化【申请号码↓】按钮
		JButton btnSetup = new JButton();
		btnSetup.setBounds(14, 179, 99, 22);
		btnSetup.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnSetup.setText("申请号码↓");
		getContentPane().add(btnSetup);

		/// 初始化当前窗口
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client.class.getResource("/resource/img/QQ.png")));
		setTitle("QQ登录");
		setResizable(false);
		getContentPane().setLayout(null);
		// 设置窗口大小
		setSize(frameWidth, frameHeight);
		// 计算窗口位于屏幕中心的坐标
		int x = (int) (screenWidth - frameWidth) / 2;
		int y = (int) (screenHeight - frameHeight) / 2;
		// 设置窗口位于屏幕中心
		setLocation(x, y);

		// 注册窗口事件
		addWindowListener(new WindowAdapter() {
			// 单击窗口关闭按钮时调用
			public void windowClosing(WindowEvent e) {
				// 退出系统
				System.exit(0);
			}
		});
	}

	// 客户端向服务器发送登录请求
	public Map login(String userId, String password) {

		// 准备一个缓冲区
		byte[] buffer = new byte[1024];
		InetAddress address;

		try {
			address = InetAddress.getByName(Client.SERVER_IP);

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("command", Client.COMMAND_LOGIN);
			jsonObj.put("user_id", userId);
			jsonObj.put("user_pwd", password);
			// 字节数组
			byte[] b = jsonObj.toString().getBytes();
			// 创建DatagramPacket对象
			DatagramPacket packet = new DatagramPacket(b, b.length, address, Client.SERVER_PORT);
			// 发送
			Client.socket.send(packet);

			/* 接收数据报 */
			packet = new DatagramPacket(buffer, buffer.length, address, Client.SERVER_PORT);
			Client.socket.receive(packet);
			// 接收数据长度
			int len = packet.getLength();
			String str = new String(buffer, 0, len);
			System.out.println("receivedjsonObj = " + str);
			JSONObject receivedjsonObj = new JSONObject(str);

			if ((Integer) receivedjsonObj.get("result") == 0) {
				Map user = receivedjsonObj.toMap();
				return user;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 蓝线面板
	private JPanel getPaneLine() {

		JPanel paneLine = new JPanel();
		paneLine.setLayout(null);
		paneLine.setBounds(7, 54, 308, 118);
		// 边框颜色设置为蓝色
		paneLine.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 255), 1));

		// 初始化【忘记密码？】标签
		JLabel lblHelp = new JLabel();
		lblHelp.setBounds(227, 47, 67, 21);
		lblHelp.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHelp.setForeground(new Color(51, 51, 255));
		lblHelp.setText("忘记密码？");
		paneLine.add(lblHelp);

		// 初始化【QQ密码】标签
		JLabel lblUserPwd = new JLabel();
		lblUserPwd.setText("QQ密码");
		lblUserPwd.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUserPwd.setBounds(21, 48, 54, 18);
		paneLine.add(lblUserPwd);

		// 初始化【QQ号码↓】标签
		JLabel lblUserId = new JLabel();
		lblUserId.setText("QQ号码↓");
		lblUserId.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUserId.setBounds(21, 14, 55, 18);
		paneLine.add(lblUserId);

		// 初始化【QQ号码】文本框

		this.txtUserId = new JTextField();
		this.txtUserId.setBounds(84, 14, 132, 18);
		paneLine.add(this.txtUserId);

		// 初始化【QQ密码】密码框
		this.txtUserPwd = new JPasswordField();
		this.txtUserPwd.setBounds(84, 48, 132, 18);
		paneLine.add(this.txtUserPwd);

		// 初始化【自动登录】复选框
		JCheckBox chbAutoLogin = new JCheckBox();
		chbAutoLogin.setText("自动登录");
		chbAutoLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		chbAutoLogin.setBounds(79, 77, 73, 19);
		paneLine.add(chbAutoLogin);

		// 初始化【隐身登录】复选框
		JCheckBox chbHideLogin = new JCheckBox();
		chbHideLogin.setText("隐身登录");
		chbHideLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		chbHideLogin.setBounds(155, 77, 73, 19);
		paneLine.add(chbHideLogin);

		return paneLine;
	}

}

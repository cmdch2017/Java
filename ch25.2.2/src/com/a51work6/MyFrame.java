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


//MyFrame.java文件
package com.a51work6;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);

		// 创建Label
		JLabel label = new JLabel("Hello Swing！");
		// 获得窗口的内容面板
		Container contentPane = getContentPane();
		// 添加Label到内容面板
		contentPane.add(label);

		// 设置窗口大小
		setSize(300, 300);
		// 设置窗口可见
		setVisible(true);
	}
}

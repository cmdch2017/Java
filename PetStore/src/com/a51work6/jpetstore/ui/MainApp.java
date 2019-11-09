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


//MainApp.java文件
package com.a51work6.jpetstore.ui;

import com.a51work6.jpetstore.domain.Account;

//启动类
public class MainApp {

	// 用户登录成功后，保存当前用户信息
	public static Account accout;

	public static void main(String[] args) {

		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
	}

}

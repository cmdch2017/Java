/*
* Created by �ǽݿ���
* ������վ��http://www.zhijieketang.com/group/5
* �ǽݿ������߿��ã�www.zhijieketang.com
* �ǽݿ���΢�Ź����ţ�zhijieketang
* ���䣺eorient@sina.com
* Java���߷���QQȺ��547370999
*
* ��Java��С�׵���ţ��ֽ�ʰ�ͼ�飬��������Ƶ
*
* �����׵����顿��ַ��
*       ͼ��������
*       http://www.ituring.com.cn/book/2480
*       �ٶ��Ķ���
*       https://yuedu.baidu.com/ebook/7c1499987e192279168884868762caaedd33ba00 
*/


//SwingDemo1.java�ļ�
package com.a51work6;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingDemo1 {

	public static void main(String[] args) {
		// �������ڶ���
		JFrame frame = new JFrame("MyFrame");

		// ����Label
		JLabel label = new JLabel("Hello Swing��");
		// ��ô��ڵ��������
		Container contentPane = frame.getContentPane();
		// ���Label���������
		contentPane.add(label);

		// ���ô��ڴ�С
		frame.setSize(300, 300);
		// ���ô��ڿɼ�
		frame.setVisible(true);
	}
}

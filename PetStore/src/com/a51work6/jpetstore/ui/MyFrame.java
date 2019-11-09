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


//MyFrame.java�ļ�
package com.a51work6.jpetstore.ui;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//����һ����Ļ���е��Զ��崰��
public class MyFrame extends JFrame {

	// ��õ�ǰ��Ļ�Ŀ�
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	// ��õ�ǰ��Ļ�ĸ�
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	public MyFrame(String title, int width, int height) {
		super(title);

		// ���ô��ڴ�С
		setSize(width, height);
		// ���㴰��λ����Ļ���ĵ�����
		int x = (int) (screenWidth - width) / 2;
		int y = (int) (screenHeight - height) / 2;
		// ���ô���λ����Ļ����
		setLocation(x, y);

		// ע�ᴰ���¼�
		addWindowListener(new WindowAdapter() {
			// �������ڹرհ�ťʱ����
			public void windowClosing(WindowEvent e) {
				// �˳�ϵͳ
				System.exit(0);
			}
		});
	}
}

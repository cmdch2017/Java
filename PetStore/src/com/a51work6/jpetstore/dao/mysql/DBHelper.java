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


//DBHelper.java�ļ�
package com.a51work6.jpetstore.dao.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//���ݿ⸨����
public class DBHelper {

	// �������ݿ�url
	static String url;
	// ����Properties����
	static Properties info = new Properties();

	// 1.�����������
	static {
		// ��������ļ�������
		InputStream input = DBHelper.class.getClassLoader()
				.getResourceAsStream("com/a51work6/jpetstore/dao/mysql/config.properties");

		try {
			// ���������ļ����ݵ�Properties����
			info.load(input);
			// �������ļ���ȡ��url
			url = info.getProperty("url");
			// �������ļ���ȡ��driver
			String driverClassName = info.getProperty("driver");
			Class.forName(driverClassName);
			System.out.println("����������سɹ�...");
		} catch (ClassNotFoundException e) {
			System.out.println("�����������ʧ��...");
		} catch (IOException e) {
			System.out.println("���������ļ�ʧ��...");
		}
	}

	// ������ݿ�����
	public static Connection getConnection() throws SQLException {
		// �������ݿ�����
		Connection conn = DriverManager.getConnection(url, info);
		return conn;
	}

}

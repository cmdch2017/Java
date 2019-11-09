package com.a51work6.qq.server;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	//链接数据url
	static String url;
	//创建properties对象
	static Properties info=new Properties();
	//1.加载驱动程序
	static {
		InputStream in=DBHelper.class.getClassLoader().getResourceAsStream("com/a51work6/qq/server/config.properties");
	try {
		info.load(in);
		url=info.getProperty("url");
		String driverClassName=info.getProperty("driver");
		Class.forName(driverClassName);
	}
	catch(Exception e) {
		System.out.println("加载驱动失败");
	}
	}
	public static Connection getConnection() throws SQLException {
		Connection conn=DriverManager.getConnection(url,info);
		return conn;
	}
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}

package com.a51work6.qq.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectReview {
	public static void Select(String str) throws SQLException {
		BookList l=new BookList();
		Connection connection=DBHelper.getConnection();
		String sql="select* from booklist where ISBN like ?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, str);
			//执行结果�?
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
                l.setISBN(rs.getString("ISBN"));
                l.setTitle(rs.getString("title"));
                l.setAuthor(rs.getString("author"));
                l.setPublish(rs.getString("publish"));
                l.setPrice(rs.getDouble("price"));
                l.setPages(rs.getInt("pages"));
                System.out.println(
                		String.format("ISBN=%s,title=%s,author=%s,publish=%s,price=%s,pages=%s",l.getISBN(),l.getTitle(),l.getAuthor(),l.getPublish(),l.getPrice(),l.getPages()));
			}
			//DBUtil.close(connection, ps, rs);
		} catch (SQLException e) {
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		}
	}
}

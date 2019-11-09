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


package com.a51work6.qq.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {

	// 查询所有用户信息
	public List<Map<String, String>> findAll() {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		// SQL语句
		String sql = "select user_id,user_pwd,user_name, user_icon from users";
		try (// 2.创建数据库连接
				Connection conn = DBUtil.getConnection();
				// 3. 创建语句对象
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// 5. 执行查询
				ResultSet rs = pstmt.executeQuery();) {

			// 6. 遍历结果集
			while (rs.next()) {

				Map<String, String> row = new HashMap<String, String>();
				row.put("user_id", rs.getString("user_id"));
				row.put("user_name", rs.getString("user_name"));
				row.put("user_pwd", rs.getString("user_pwd"));
				row.put("user_icon", rs.getString("user_icon"));

				list.add(row);
			}

		} catch (SQLException e) {
		}

		return list;
	}

	// 按照主键查询
	public Map<String, String> findById(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// SQL语句
		String sql = "select user_id,user_pwd,user_name, user_icon from users where user_id = ?";
		try {
			// 2.创建数据库连接
			conn = DBUtil.getConnection();
			// 3. 创建语句对象

			pstmt = conn.prepareStatement(sql);
			// 4. 绑定参数
			pstmt.setString(1, id);
			// 5. 执行查询（R）
			rs = pstmt.executeQuery();
			// 6. 遍历结果集
			if (rs.next()) {
				
				Map<String, String> row = new HashMap<String, String>();
				row.put("user_id", rs.getString("user_id"));
				row.put("user_name", rs.getString("user_name"));
				row.put("user_pwd", rs.getString("user_pwd"));
				row.put("user_icon", rs.getString("user_icon"));

				return row;
			}

		} catch (SQLException e) {
		} finally { // 释放资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return null;
	}

	// 查询好友 列表
	public List<Map<String, String>> findFriends(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String, String>> friends = new ArrayList<Map<String, String>>();
		// SQL语句
		String sql = "select user_id,user_pwd,user_name,user_icon FROM users " + " WHERE "
				+ "    user_id IN (select user_id2 as user_id  from friend where user_id1 = ?)"
				+ " OR user_id IN (select user_id1 as user_id  from friend where user_id2 = ?)";
		try {
			// 2.创建数据库连接
			conn = DBUtil.getConnection();
			// 3. 创建语句对象

			pstmt = conn.prepareStatement(sql);
			// 4. 绑定参数
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			// 5. 执行查询（R）
			rs = pstmt.executeQuery();
			// 6. 遍历结果集
			while (rs.next()) {

				Map<String, String> row = new HashMap<String, String>();
				row.put("user_id", rs.getString("user_id"));
				row.put("user_name", rs.getString("user_name"));
				row.put("user_pwd", rs.getString("user_pwd"));
				row.put("user_icon", rs.getString("user_icon"));

				friends.add(row);
			}

		} catch (SQLException e) {
		} finally { // 释放资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return friends;
	}

}

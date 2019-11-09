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


//AccountDaoImp.java文件
package com.a51work6.jpetstore.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.a51work6.jpetstore.dao.AccountDao;
import com.a51work6.jpetstore.domain.Account;

//用户管理DAO
public class AccountDaoImp implements AccountDao {

	@Override
	public List<Account> findAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Account findById(String userid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
		try {
			// 2.创建数据库连接
			conn = DBHelper.getConnection();
			// 3. 创建语句对象
			String sql = "select userid,password,email,name,addr,city,country,phone"
					+ " from account where userid = ?";
			pstmt = conn.prepareStatement(sql);
			// 4. 绑定参数
			pstmt.setString(1, userid);
			// 5. 执行查询（R）
			rs = pstmt.executeQuery();
			// 6. 遍历结果集
			if (rs.next()) {
				account = new Account();

				account.setUserid(rs.getString("userid"));
				account.setPassword(rs.getString("password"));
				account.setEmail(rs.getString("email"));
				account.setUsername(rs.getString("name"));
				account.setAddr(rs.getString("addr"));
				account.setCity(rs.getString("city"));
				account.setCountry(rs.getString("country"));
				account.setPhone(rs.getString("phone"));

				return account;
			}

		} catch (SQLException e) {
			e.printStackTrace();
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

	@Override
	public int create(Account account) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int modify(Account account) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int remove(Account account) {
		// TODO 自动生成的方法存根
		return 0;
	}

}

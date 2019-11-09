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


//AccountDaoImp.java�ļ�
package com.a51work6.jpetstore.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.a51work6.jpetstore.dao.AccountDao;
import com.a51work6.jpetstore.domain.Account;

//�û�����DAO
public class AccountDaoImp implements AccountDao {

	@Override
	public List<Account> findAll() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Account findById(String userid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
		try {
			// 2.�������ݿ�����
			conn = DBHelper.getConnection();
			// 3. ����������
			String sql = "select userid,password,email,name,addr,city,country,phone"
					+ " from account where userid = ?";
			pstmt = conn.prepareStatement(sql);
			// 4. �󶨲���
			pstmt.setString(1, userid);
			// 5. ִ�в�ѯ��R��
			rs = pstmt.executeQuery();
			// 6. ���������
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
		} finally { // �ͷ���Դ
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
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int modify(Account account) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int remove(Account account) {
		// TODO �Զ����ɵķ������
		return 0;
	}

}

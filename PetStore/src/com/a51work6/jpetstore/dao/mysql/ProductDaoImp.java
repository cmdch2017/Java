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


//ProductDaoImp.java�ļ�
package com.a51work6.jpetstore.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.a51work6.jpetstore.dao.ProductDao;
import com.a51work6.jpetstore.domain.Product;

//��Ʒ����DAO
public class ProductDaoImp implements ProductDao {

	@Override
	public List<Product> findAll() {

		String sql = "select productid,category,cname,ename,image,"
				+ "listprice,unitcost,descn from product";
		List<Product> products = new ArrayList<Product>();

		try (
				// 2.�������ݿ�����
				Connection conn = DBHelper.getConnection();
				// 3. ����������
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// 4. �󶨲���
				// 5. ִ�в�ѯ��R��
				ResultSet rs = pstmt.executeQuery()) {

			// 6. ���������
			while (rs.next()) {
				Product p = new Product();
				p.setProductid(rs.getString("productid"));
				p.setCategory(rs.getString("category"));
				p.setCname(rs.getString("cname"));
				p.setEname(rs.getString("ename"));
				p.setImage(rs.getString("image"));
				p.setListprice(rs.getDouble("listprice"));
				p.setUnitcost(rs.getDouble("unitcost"));
				p.setDescn(rs.getString("descn"));

				products.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> findByCategory(String category) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();

		try {
			// 2.�������ݿ�����
			conn = DBHelper.getConnection();
			// 3. ����������
			String sql = "select productid,category,cname,ename,image,listprice,unitcost,descn "
					+ "from product where category=?";

			pstmt = conn.prepareStatement(sql);
			// 4. �󶨲���
			pstmt.setString(1, category);
			// 5. ִ�в�ѯ��R��
			rs = pstmt.executeQuery();
			// 6. ���������
			while (rs.next()) {
				Product p = new Product();
				p.setProductid(rs.getString("productid"));
				p.setCategory(rs.getString("category"));
				p.setCname(rs.getString("cname"));
				p.setEname(rs.getString("ename"));
				p.setImage(rs.getString("image"));
				p.setListprice(rs.getDouble("listprice"));
				p.setUnitcost(rs.getDouble("unitcost"));
				p.setDescn(rs.getString("descn"));

				products.add(p);
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

		return products;
	}

	@Override
	public Product findById(String productid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2.�������ݿ�����
			conn = DBHelper.getConnection();
			// 3. ����������
			String sql = "select productid,category,cname,ename,image,listprice,unitcost,descn "
					+ "from product where productid=?";

			pstmt = conn.prepareStatement(sql);
			// 4. �󶨲���
			pstmt.setString(1, productid);
			// 5. ִ�в�ѯ��R��
			rs = pstmt.executeQuery();
			// 6. ���������
			if (rs.next()) {
				
				Product p = new Product();
				p.setProductid(rs.getString("productid"));
				p.setCategory(rs.getString("category"));
				p.setCname(rs.getString("cname"));
				p.setEname(rs.getString("ename"));
				p.setImage(rs.getString("image"));
				p.setListprice(rs.getDouble("listprice"));
				p.setUnitcost(rs.getDouble("unitcost"));
				p.setDescn(rs.getString("descn"));

				return p;
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
	public int create(Product product) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int modify(Product product) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int remove(Product product) {
		// TODO �Զ����ɵķ������
		return 0;
	}

}

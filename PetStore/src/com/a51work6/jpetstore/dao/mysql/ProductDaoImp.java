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


//ProductDaoImp.java文件
package com.a51work6.jpetstore.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.a51work6.jpetstore.dao.ProductDao;
import com.a51work6.jpetstore.domain.Product;

//商品管理DAO
public class ProductDaoImp implements ProductDao {

	@Override
	public List<Product> findAll() {

		String sql = "select productid,category,cname,ename,image,"
				+ "listprice,unitcost,descn from product";
		List<Product> products = new ArrayList<Product>();

		try (
				// 2.创建数据库连接
				Connection conn = DBHelper.getConnection();
				// 3. 创建语句对象
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// 4. 绑定参数
				// 5. 执行查询（R）
				ResultSet rs = pstmt.executeQuery()) {

			// 6. 遍历结果集
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
			// 2.创建数据库连接
			conn = DBHelper.getConnection();
			// 3. 创建语句对象
			String sql = "select productid,category,cname,ename,image,listprice,unitcost,descn "
					+ "from product where category=?";

			pstmt = conn.prepareStatement(sql);
			// 4. 绑定参数
			pstmt.setString(1, category);
			// 5. 执行查询（R）
			rs = pstmt.executeQuery();
			// 6. 遍历结果集
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

		return products;
	}

	@Override
	public Product findById(String productid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2.创建数据库连接
			conn = DBHelper.getConnection();
			// 3. 创建语句对象
			String sql = "select productid,category,cname,ename,image,listprice,unitcost,descn "
					+ "from product where productid=?";

			pstmt = conn.prepareStatement(sql);
			// 4. 绑定参数
			pstmt.setString(1, productid);
			// 5. 执行查询（R）
			rs = pstmt.executeQuery();
			// 6. 遍历结果集
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
	public int create(Product product) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int modify(Product product) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int remove(Product product) {
		// TODO 自动生成的方法存根
		return 0;
	}

}

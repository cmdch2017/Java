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


//ProductTableModel.java文件
package com.a51work6.jpetstore.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.a51work6.jpetstore.domain.Product;

//商品列表表格模型
public class ProductTableModel extends AbstractTableModel {

	// 表格列名columnNames
	private String[] columnNames = { "商品编号", "商品类别", "商品中文名", "商品英文名" };

	// 表格中的数据内容保存在List集合中
	private List<Product> data = null;

	public ProductTableModel(List<Product> data) {
		this.data = data;
	}

	// 返回列数
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	// 返回行数
	@Override
	public int getRowCount() {
		return data.size();
	}

	// 获得某行某列的数据，而数据保存在对象数组data中
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		// 每一行就是一个Product商品对象
		Product p = data.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return p.getProductid(); // 第一列商品编号
		case 1:
			return p.getCategory(); // 第二列商品类别
		case 2:
			return p.getCname(); // 第三列商品中文名
		default:
			return p.getEname(); // 第四列商品英文名
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}

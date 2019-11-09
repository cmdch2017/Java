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


//ProductTableModel.java�ļ�
package com.a51work6.jpetstore.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.a51work6.jpetstore.domain.Product;

//��Ʒ�б���ģ��
public class ProductTableModel extends AbstractTableModel {

	// �������columnNames
	private String[] columnNames = { "��Ʒ���", "��Ʒ���", "��Ʒ������", "��ƷӢ����" };

	// ����е��������ݱ�����List������
	private List<Product> data = null;

	public ProductTableModel(List<Product> data) {
		this.data = data;
	}

	// ��������
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	// ��������
	@Override
	public int getRowCount() {
		return data.size();
	}

	// ���ĳ��ĳ�е����ݣ������ݱ����ڶ�������data��
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		// ÿһ�о���һ��Product��Ʒ����
		Product p = data.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return p.getProductid(); // ��һ����Ʒ���
		case 1:
			return p.getCategory(); // �ڶ�����Ʒ���
		case 2:
			return p.getCname(); // ��������Ʒ������
		default:
			return p.getEname(); // ��������ƷӢ����
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}

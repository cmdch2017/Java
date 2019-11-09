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


//CartTableModel.java�ļ�
package com.a51work6.jpetstore.ui;

import javax.swing.table.AbstractTableModel;

//���ﳵ���ģ��
public class CartTableModel extends AbstractTableModel {

	// �������columnNames
	private String[] columnNames = { "��Ʒ���", "��Ʒ��", "��Ʒ����", "����", "��ƷӦ�����" };

	// ��������ݱ�����data��ά������
	private Object[][] data = null;

	public CartTableModel(Object[][] data) {
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
		return data.length;
	}

	// ���ĳ��ĳ�е����ݣ������ݱ����ڶ�������data��
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// �����п����޸�
		if (columnIndex == 3) {
			return true;
		}
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// ֻ�����޸�������
		if (columnIndex != 3) {
			return;
		}
		try {
			// �ӱ��л���޸�֮�����Ʒ�������ӱ���������ݶ�String����
			int quantity = new Integer((String) aValue);
			// ��Ʒ��������С��0
			if (quantity < 0) {
				return;
			}
			// ����������
			data[rowIndex][3] = quantity;
			// ������ƷӦ�����
			double unitcost = (double) data[rowIndex][2];
			double totalPrice = unitcost * quantity;
			// ������ƷӦ�������
			data[rowIndex][4] = new Double(totalPrice);

		} catch (Exception e) {
		}
	}

}

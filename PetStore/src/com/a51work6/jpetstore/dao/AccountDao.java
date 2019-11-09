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


package com.a51work6.jpetstore.dao;

import java.util.List;

import com.a51work6.jpetstore.domain.Account;

//�û�����DAO
public interface AccountDao {

	// ��ѯ���е��û���Ϣ
	List<Account> findAll();

	// ����������ѯ�û���Ϣ
	Account findById(String userid);

	// �����û���Ϣ
	int create(Account account);

	// �޸��û���Ϣ
	int modify(Account account);

	// ɾ���û���Ϣ
	int remove(Account account);

}

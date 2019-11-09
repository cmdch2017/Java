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


package com.a51work6.jpetstore.dao;

import java.util.List;

import com.a51work6.jpetstore.domain.Account;

//用户管理DAO
public interface AccountDao {

	// 查询所有的用户信息
	List<Account> findAll();

	// 根据主键查询用户信息
	Account findById(String userid);

	// 创建用户信息
	int create(Account account);

	// 修改用户信息
	int modify(Account account);

	// 删除用户信息
	int remove(Account account);

}

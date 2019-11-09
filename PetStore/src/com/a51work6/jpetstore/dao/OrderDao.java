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

import com.a51work6.jpetstore.domain.Order;

//订单管理DAO
public interface OrderDao {
	// 查询所有的订单信息
	List<Order> findAll();

	// 根据主键查询订单信息
	Order findById(int orderid);

	// 创建订单信息
	int create(Order order);

	// 修改订单信息
	int modify(Order order);

	// 删除订单信息
	int remove(Order order);

}

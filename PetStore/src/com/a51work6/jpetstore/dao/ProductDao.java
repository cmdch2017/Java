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

import com.a51work6.jpetstore.domain.Product;

//商品管理DAO
public interface ProductDao {
	// 查询所有的商品信息
	List<Product> findAll();

	// 根据主键查询商品信息
	Product findById(String productid);

	// 根据按照列表查询商品信息
	List<Product> findByCategory(String category);

	// 创建商品信息
	int create(Product product);

	// 修改商品信息
	int modify(Product product);

	// 删除商品信息
	int remove(Product product);

}

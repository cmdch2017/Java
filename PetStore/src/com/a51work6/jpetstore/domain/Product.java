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


//Product.java文件
package com.a51work6.jpetstore.domain;

public class Product {

	private String productid; 	// 商品Id
	private String category; 	// 商品类别
	private String cname; 		// 商品中文名
	private String ename; 		// 商品英文名
	private String image; 		// 商品图片
	private String descn; 		// 商品描述
	private double listprice; 	// 商品市场价
	private double unitcost; 	// 商品单价

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public double getListprice() {
		return listprice;
	}

	public void setListprice(double listprice) {
		this.listprice = listprice;
	}

	public double getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(double unitcost) {
		this.unitcost = unitcost;
	}

}

package com.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年12月1日 下午4:18:56
* 商品的Action
*/
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//用于接收数据的模型驱动
	private Product product=new Product();
	
	//注入商品的Service
	private ProductService  productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Override
	public Product getModel() {
		
		return product;
	}
	//根据商品的ID查询商品
	public String findByPid() {
		//调用service的方法完成查询
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}

}

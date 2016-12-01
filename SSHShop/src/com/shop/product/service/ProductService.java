package com.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.product.dao.ProductDao;
import com.shop.product.vo.Product;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年12月1日 下午4:19:28
* 业务层商品代码
*/
@Transactional
public class ProductService {
//注入ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
//首页上热门商品的查询
	public List<Product> finHotPoduct() {
		
		return productDao.findHotProduct();
	}
	//首页最新商品查询
	public List<Product> findNewProduct() {
		
		return productDao.findNewProduct();
	}
	//根据商品的id查询商品
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	
	
	
}

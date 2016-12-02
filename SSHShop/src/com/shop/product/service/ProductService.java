package com.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.product.dao.ProductDao;
import com.shop.product.vo.Product;
import com.shop.utils.PageBean;

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
	//分页查询商品
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit=10;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount=0;
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		//Math.ceil(totalCount/limit);
		if (totalCount%limit==0) {
			totalPage=totalCount/limit;
		}else {
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示数据的集合
		//从哪开始
		int begin=(page-1)*limit;
		List<Product> list=productDao.findByCidPage(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	

	
	
	
	
}

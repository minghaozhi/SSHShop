package com.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.category.dao.CategoryDao;
import com.shop.category.vo.Category;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年12月1日 下午1:55:33
* 一级分类的业务逻辑
*/
@Transactional
public class CategoryService {
	//注入CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
 //业务层查询所有一级分类的方法
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

	
	
	

}

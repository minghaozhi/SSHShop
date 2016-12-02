package com.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.category.vo.Category;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年12月1日 下午1:55:33
* 类说明
*/
public class CategoryDao extends HibernateDaoSupport{
	
    //DAO查询所有一级分类的方法
	public List<Category> findAll() {
		String hql="from Category";
		
		List<Category> list=this.getHibernateTemplate().find(hql);
		
		return list;
	}

}

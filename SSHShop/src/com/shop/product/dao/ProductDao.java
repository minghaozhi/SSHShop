package com.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.product.vo.Product;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年12月1日 下午4:19:11
* 商品持久层
*/
public class ProductDao extends HibernateDaoSupport{

	//首页热门商品的查询
	public List<Product> findHotProduct() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门商品，条件是is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序排序
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
	List<Product> hpLis=this.getHibernateTemplate().findByCriteria(criteria,0,10);
		
		return hpLis;
	}
    //首页最新商品查询
	public List<Product> findNewProduct() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//按日期倒序
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria,0,10);

		return list;
	}
	//根据商品id查询商品
	public Product  findByPid(Integer pid) {
		
		return this.getHibernateTemplate().get(Product.class, pid);
	}

}

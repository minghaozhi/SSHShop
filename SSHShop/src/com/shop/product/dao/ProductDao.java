package com.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.product.vo.Product;
import com.shop.utils.PageHibernateCallback;

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
	//根据分类的id查询商品的个数
	public int findCountCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
	List<Long> list=this.getHibernateTemplate().find(hql,cid);
	if (list!=null&&list.size()>0) {
		return list.get(0).intValue();
	}
		return 0;
	}
	//根据商品id查询商品的集合
	public List<Product> findByCidPage(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		// 分页另一种写法:
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

}

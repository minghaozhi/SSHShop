package com.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.w3c.dom.ls.LSInput;

import com.shop.user.vo.User;


/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年11月28日 下午5:53:16
* 用户模块持久层
*/
public class UserDao extends HibernateDaoSupport{

	//按名称查询是否有用户
	public User findByUserName(String username){
		String hql="from User where username=?";
		List<User> list= this.getHibernateTemplate().find(hql,username);
		if (list!=null&&list.size()>0) {
			return list.get(0);
			}
		return null;
	}
     //注册用户存入数据库
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}
}

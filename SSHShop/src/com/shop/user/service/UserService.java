package com.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.shop.user.dao.UserDao;
import com.shop.user.vo.User;
import com.shop.utils.MailUtils;
import com.shop.utils.UUIDUtils;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年11月28日 下午5:53:26
* 用户模块业务层
*/
@Transactional
public class UserService {

	//注入UserDao
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//按用户名查询用户的方法
	
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}
   //业务层完成用户注册
	public void save(User user) {
		user.setState(0);  //0代表用户未激活， 1代表用户已被激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//发送激活邮件
		MailUtils.sendMail(user.getEmail(), code);
	}
//业务层根据激活码查询
	public User finByCode(String code) {
		return userDao.findByCode(code);
	}
  //修改用户状态
	public void update(User existUser) {
		userDao.update(existUser);
		
	}
    //用户登录的方法
	public User login(User user) {
		return userDao.login(user);
		
	}
}

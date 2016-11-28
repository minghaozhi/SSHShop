package com.shop.user.action;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.user.service.UserService;
import com.shop.user.vo.User;
/**
 */
/**
 * 用户模块Action的类
 * 
 * @author minghaozhi
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
//模型驱动使用的对象
	private User user=new User();
	
	//注入UserService
	private UserService userService;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {
		
		return user;
	}
	/**
	 * 跳转到注册页面的执行方法
	 */
	public String registPage() {
		return "registPage";
	}
/**
 * 前台AJAX校验用户名的执行方法
 * @throws IOException 
 */
	public String checkUserName() throws IOException {
		
		//调用service
		User existUser=userService.findByUserName(user.getUsername());
		//获得response对象，向页面输出
		  HttpServletResponse response = ServletActionContext.getResponse();
		  response.setContentType("text/html,charset=utf-8");
		//判断
		if (existUser!=null) {
			//查询到该用户，该用户已存在
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		}else {
			//没查到该用户
			response.getWriter().println("<font color='green'>用户名可以使用</font>");

		}
		return NONE;
	}


}

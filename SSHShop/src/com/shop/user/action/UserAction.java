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
		  response.setContentType("text/html;charset=utf-8");
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
/**
 * 用户注册的方法
 */
   public String regist(){
	   userService.save(user);
	   this.addActionMessage("注册成功！请去邮箱激活");
	   return "msg";
   }
   /**
    * 用户激活的方法
    */
   public String active(){
	   //根据激活码查询用户：
	 User existUser=userService.finByCode(user.getCode());
	 if (existUser==null) {
		 //激活码错误、
		 this.addActionMessage("激活失败！激活码错误或失效！");
		
	}else {
		existUser.setState(1);
		existUser.setCode(null);
		userService.update(existUser);
		this.addActionMessage("激活成功，请登录！");
	}
	   return "msg";
   }
   /**
    * 跳转到登录页面
    */
   public String loginPage(){
	   return "loginPage";
   }
   /**
    * 登陆的方法
    */
   public String login(){
	 User user1=userService.login(user);
	 if (user1==null) {
		 this.addActionError("登陆失败，用户名或密码错误！");
		 return "loginSuccess";
		
	}else {
		//将用户的信息存入到session中
		ServletActionContext.getRequest().getSession().setAttribute("user1", user1);
		//页面跳转
		return "loginSucess";
	}
	 
   }
}

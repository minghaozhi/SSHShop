package com.shop.home.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页访问的Action
 * @author minghaozhi
 *
 */
public class IndexAction extends ActionSupport{

	/**
	 * 执行的访问首页的方法:
	 */
	public String execute(){
		
		return "index";
	}
	
	
}

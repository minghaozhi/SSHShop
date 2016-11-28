package cn.itcast.shop.index.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页访问的Action
 * @author 传智.郭嘉
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

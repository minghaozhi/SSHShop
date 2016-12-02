package com.shop.category.vo;

import java.util.HashSet;
import java.util.Set;

import com.shop.categorySecond.vo.CategorySecond;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年12月1日 下午1:47:10
* 一級分類的实体类对象
*/
public class Category {
	private Integer cid;
	private String cname;
	//存放二级分类的集合
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
	

}

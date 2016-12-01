package com.shop.home.action;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.category.service.CategoryService;
import com.shop.category.vo.Category;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;

/**
 * 首页访问的Action
 * @author minghaozhi
 *
 */
public class IndexAction extends ActionSupport{
	
	//注入一级分类的Service
	private CategoryService categoryService;
	

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//注入商品的service
		private ProductService productService;
		
	public void setProductService(ProductService productService) {
			this.productService = productService;
		}

	/**
	 * 执行的访问首页的方法:
	 */
	public String execute(){
		//查询所有一级分类集合
	List<Category> cList=categoryService.findAll();
	//将一级分类存入到Session范围
	ActionContext.getContext().getSession().put("cList", cList);
		//查询热门商品
	List<Product> hPList=productService.finHotPoduct();
	//保存到值栈
	ActionContext.getContext().getValueStack().set("hPList", hPList);;
		return "index";
	}
	
	
}

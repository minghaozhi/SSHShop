package com.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.service.CategoryService;
import com.shop.category.vo.Category;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;
import com.shop.utils.PageBean;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年12月1日 下午4:18:56
* 商品的Action
*/
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//用于接收数据的模型驱动
	private Product product=new Product();
	
	//注入商品的Service
	private ProductService  productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	private Integer cid;
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//注入一级分类的service
	private CategoryService categoryService;
	
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//接收当前页数
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public Product getModel() {
		
		return product;
	}
	//根据商品的ID查询商品
	public String findByPid() {
		//调用service的方法完成查询
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}
//根据分类的ID查询商品
	public String findByCid(){
		
		//List<Category> cList=categoryService.findAll();
		PageBean<Product> pageBean=productService.findByPageCid(cid,page);//根据一级分类查询，分页查
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	
	}
}

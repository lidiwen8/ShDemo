package com.lidiwen.action;

import java.util.ArrayList;
import java.util.List;

import com.lidiwen.dao.CategoryDAO;
import com.lidiwen.dao.ProductDAO;
import com.lidiwen.page.Page;
import com.lidiwen.pojo.Category;
import com.lidiwen.pojo.Product;

/**
 * @Auther: lidiwen
 * @Date: 2019/5/16 11:21
 * @Description:
 */
public class ProductAction {

	ProductDAO pdao = new ProductDAO();
	CategoryDAO cdao = new CategoryDAO();
	Product product;
	List<Product> products;
	List<Category> categorys;
	Category category;
	String pageNo;
	Page page;
	

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<Category> getCategorys() {
		return categorys;
	}


	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	public String add() {
		System.out.println(product.getName());
        System.out.println(product.getPrice());
		System.out.println(product.getCategory().getName());
		pdao.add(product);
		return "list";
	}
	public String edit() {
		// 2.接受参数
		String no= getPageNo();
		// 3.业务处理
		int pageSize=3; //页面大小
		int pageNo=1; //默认的pageNo为1
		if(no!=null && no!=""){
			pageNo=Integer.valueOf(no);
		}
		//获取总条数
		int totalCount=pdao.getTotalCount();
		//封装分页所需字段
		page=new Page(pageSize, pageNo, totalCount);
		categorys =cdao.listCategory(page);
		products =pdao.listProduct(page);
        product =pdao.get(product.getId());
		return "edit";
	}
	public String delete() {
		pdao.delete(product.getId());
		return "list";
	}
	public String update() {
		pdao.update(product);
		return "list";
	}
	public String list() {
		// 2.接受参数
		String no= getPageNo();
		// 3.业务处理
		int pageSize=3; //页面大小
		int pageNo=1; //默认的pageNo为1
		if(no!=null && no!=""){
			pageNo=Integer.valueOf(no);
		}
		//获取总条数
		int totalCount=pdao.getTotalCount();
		page=new Page(pageSize, pageNo, totalCount);
		categorys = cdao.listCategory(page);
		if(null!=category){
			category = cdao.get(category.getId());
			products = new ArrayList(  category.getProducts());
			return "listJsp";
		}
		else{
			products = pdao.listProduct(page);
			return "listJsp";			
		}
		
		
		


	}

}

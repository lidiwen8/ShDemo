package com.lidiwen.action;

import java.util.ArrayList;
import java.util.List;

import com.lidiwen.dao.CategoryDAO;
import com.lidiwen.page.Page;
import com.lidiwen.pojo.Category;

/**
 * @Auther: lidiwen
 * @Date: 2019/5/16 11:21
 * @Description:
 */
public class CategoryAction {

	CategoryDAO cdao = new CategoryDAO();
	Category category;
	List<Category> categorys;
	String pageNo;
	Page page;

	public List<Category> getCategorys() {
		return categorys;
	}


	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		
		this.category = category;
	}

	public String getPageNo() {
		return pageNo;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String add() {
		cdao.add(category);
		return "list";
	}
	public String edit() {
		category =cdao.get(category.getId());
//        cdao.update(category);
		return "edit";
	}
	public String delete() {
		cdao.delete(category.getId());
		return "list";
	}
	public String update() {
		cdao.update(category);
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
		int totalCount=cdao.getTotalCount();
		page=new Page(pageSize, pageNo, totalCount);
		categorys = cdao.listCategory(page);
		return "listJsp";
	}

}

package com.lidiwen.pojo;

import java.util.Set;

/**
 * @Auther: lidiwen
 * @Date: 2019/5/16 11:21
 * @Description:
 */
public class Category {

	private int id;
	private String name;
	Set<Product> products;
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}

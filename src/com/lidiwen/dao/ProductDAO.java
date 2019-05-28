package com.lidiwen.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lidiwen.hibernate.HibernateUtil;
import com.lidiwen.page.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lidiwen.pojo.Product;

/**
 * @Auther: lidiwen
 * @Date: 2019/5/16 11:21
 * @Description:
 */
public class ProductDAO {

	public void add(Product p) {
		List<Product> result = new ArrayList();

		Session s = HibernateUtil.currentSession();
		s.beginTransaction();

		s.save(p);

		s.getTransaction().commit();
		HibernateUtil.clossSession();
	}

	public Product get(int id) {
		Product result = null;

		Session s = HibernateUtil.currentSession();

		result = (Product) s.get(Product.class, id);

		HibernateUtil.clossSession();
		return result;
	}

	public void delete(int id) {
		List<Product> result = new ArrayList();

		Session s = HibernateUtil.currentSession();
		s.beginTransaction();

		Product p = (Product) s.get(Product.class, id);

		s.delete(p);

		s.getTransaction().commit();
		HibernateUtil.clossSession();
	}

	public void update(Product p) {
		List<Product> result = new ArrayList();
		Session s = HibernateUtil.currentSession();
		s.beginTransaction();

		s.update(p);

		s.getTransaction().commit();
		HibernateUtil.clossSession();
	}

	public List<Product> listProduct(Page page) {
		List<Product> result = new ArrayList();

		Session s = HibernateUtil.currentSession();

		Query q = s.createQuery("from Product p");
		//1.查询最大记录数的数据
		q.setMaxResults(page.getPagesize());

		//2.确定查询起点
		q.setFirstResult(page.getStartrow());
		//3.分页查询
		result = q.list();

		HibernateUtil.clossSession();
		return result;
	}

	public int getTotalCount() {
		//1.获取session
		Session session = HibernateUtil.currentSession();

		//2.定义查询总条数hql语句
		String hqlcount = "select count(*) from Product";

		//3.利用Session创建Query对象
		Query querycount = session.createQuery(hqlcount);

		//4.获取总条数(返回单行数据uniqueResult())
		Integer totalCount = Integer.parseInt(querycount.uniqueResult().toString());
		//5.释放资源
		HibernateUtil.clossSession();
		return totalCount;
	}
	
//	public static void main(String[] args) {
//
//		Product p =new Product();
//		p.setName("name1");
//		p.setPrice(1);
//
//		new ProductDAO().add(p);
//
//
//	}

}

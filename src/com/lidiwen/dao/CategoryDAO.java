package com.lidiwen.dao;

import java.util.ArrayList;
import java.util.List;

import com.lidiwen.hibernate.HibernateUtil;
import com.lidiwen.page.Page;
import org.hibernate.Query;
import org.hibernate.Session;

import com.lidiwen.pojo.Category;

/**
 * @Auther: lidiwen
 * @Date: 2019/5/16 11:21
 * @Description:
 */
public class CategoryDAO {

	public void add(Category p) {
		List<Category> result = new ArrayList();

		Session s = HibernateUtil.currentSession();
		s.beginTransaction();

		s.save(p);

		s.getTransaction().commit();
		HibernateUtil.clossSession();
	}

	public Category get(int id) {
		Category result = null;

		Session s = HibernateUtil.currentSession();

		result = (Category) s.get(Category.class, id);

		HibernateUtil.clossSession();
		return result;
	}

	public void delete(int id) {
		List<Category> result = new ArrayList();

		Session s = HibernateUtil.currentSession();
		s.beginTransaction();

		Category p = (Category) s.get(Category.class, id);

		s.delete(p);

		s.getTransaction().commit();
		HibernateUtil.clossSession();
	}

	public void update(Category p) {
		List<Category> result = new ArrayList();

		Session s = HibernateUtil.currentSession();
		s.beginTransaction();
		s.update(p);

		s.getTransaction().commit();
		HibernateUtil.clossSession();
	}

	public List<Category> listCategory(Page page) {
		List<Category> result = new ArrayList();

		Session session = HibernateUtil.currentSession();

		Query q = session.createQuery("from Category p");

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
		String hqlcount = "select count(*) from Category";

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
//		Category p =new Category();
//		p.setName("name1");
//
//
//		new CategoryDAO().add(p);
//
//
//	}

}

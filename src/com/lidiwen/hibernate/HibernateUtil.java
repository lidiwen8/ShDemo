package com.lidiwen.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory;
    static
    {
        try{
            Configuration configuration=new Configuration().configure();
            sessionFactory=configuration.buildSessionFactory();
        }catch (Throwable ex){
            System.out.println("初始化sessionFactory失败："+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //ThreadLocal可以隔离多个线程的数据共享，因此不需要对线程进行同步
    public static ThreadLocal<Session> session = new ThreadLocal<Session>();

    public static Session currentSession() {

        Session s = session.get();
        //如果该线程还没有Session，则创建一个新的Session
        if (s == null)
        {
            s = sessionFactory.openSession();
            //将获得的Session变量存储在ThreadLocal变量session里
            session.set(s);
        }
        return s;
    }

    public static void clossSession() {
        Session s = session.get();
        if (s != null)
        {
            s.close();
        }
        session.set(null);
    }
}

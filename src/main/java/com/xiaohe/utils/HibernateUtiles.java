package com.xiaohe.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtiles {

    private static Session session;

    public static Session getSession(String path){

        Configuration configure = new Configuration().configure(path);
        SessionFactory sessionFactory = configure.buildSessionFactory();
        return session = sessionFactory.openSession();
    }

}

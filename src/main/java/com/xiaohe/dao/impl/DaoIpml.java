package com.xiaohe.dao.impl;

import com.xiaohe.dao.Dao;
import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.User;
import com.xiaohe.utils.HibernateUtiles;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DaoIpml implements Dao {
    /**
     * 查询
     * @param user
     * @return
     */
    public Acount queryAccount(User user) {
        Session session = HibernateUtiles.getSession("hibernate.cfg.xml");
        Acount acount = (Acount) session.createQuery("from Acount where uid = :uid").setInteger("uid" ,user.getId()).list().get(0);

        return acount;

    }

    /*
    取钱
     */
    public boolean getMoney(User user, Double money) {
        Session session = HibernateUtiles.getSession("hibernate.cfg.xml");
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("update Account set salary = salary - :money").setDouble("money", money);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }

        return true;
    }
    /*
    存钱
     */
    public boolean addMoney(User user, Double money) {

        Session session = HibernateUtiles.getSession("hibernate.cfg.xml");
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("update Acount set salary = salary + :money").setDouble("money", money);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

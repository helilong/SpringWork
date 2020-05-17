package com.xiaohe.test;

import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.User;
import com.xiaohe.utils.HibernateUtiles;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestAddUser {




    @Test
    public void T(){
        Session session = HibernateUtiles.getSession("hibernate.cfg.xml");
        Transaction transaction = session.beginTransaction();

        User user = new User("传永永", "18岁");

        Acount acount = new Acount(100.00);

        user.setAcount(acount);
        acount.setUser(user);

        session.save(user);
        transaction.commit();
        session.close();
    }
}

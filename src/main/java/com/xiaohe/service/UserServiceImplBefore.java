package com.xiaohe.service;

import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.Record;
import com.xiaohe.pojo.User;
import com.xiaohe.utils.HibernateUtiles;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UserServiceImplBefore implements MethodBeforeAdvice {


    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[info]: 执行了" + method.getName() + "方法");

        User user = (User) args[0];

        Session session = HibernateUtiles.getSession("hibernate.cfg.xml");
        Transaction transaction = session.beginTransaction();

        Acount acount = (Acount) session.createQuery("from Account where uid = :uid").setInteger("uid", user.getId()).list().get(0);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());

        Record record = new Record(user.getUname(), acount.getSalary(), target.getClass().getName() + "下的" + method.getName() + "()", date);
        record.setUser(user);

        try {
            session.save(record);
            transaction.commit();
            session.close();
            System.out.println("添加了一条" + method.getName() + "()方法日志");
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            System.out.println("添加日志失败");
        }
    }

}


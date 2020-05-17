package com.xiaohe.service;



import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.Record;
import com.xiaohe.pojo.User;
import com.xiaohe.utils.HibernateUtiles;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceImplProxy implements InvocationHandler {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Object getProxyClass(){
       return Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), this);
    }

    public Object invoke(Object target, Method method, Object[] args) throws Throwable {

        log(method.getName(), (User) args[0]);

        Object invoke = method.invoke(userService, args);

        return invoke;

    }

    private void log(Object object, User user){
        System.out.println("[info]: 执行了" + object + "方法");

        Session session = HibernateUtiles.getSession("hibernate.cfg.xml");
        Transaction transaction = session.beginTransaction();

        Acount account = (Acount) session.createQuery("from Account where uid = :uid").setInteger("uid", user.getId()).list().get(0);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());

        Record record = new Record(user.getUname(), account.getSalary(), object + "()", date);
        record.setUser(user);

        try {
            session.save(record);
            transaction.commit();
            session.close();
            System.out.println("添加了一条" + object + "()方法日志");
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            System.out.println("添加日志失败");
        }

    }

}

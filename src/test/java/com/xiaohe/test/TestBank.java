package com.xiaohe.test;

import com.xiaohe.dao.impl.DaoIpml;
import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.User;
import com.xiaohe.service.Impl.UserServiceImpl;
import com.xiaohe.service.UserService;
import com.xiaohe.service.UserServiceImplProxy;
import com.xiaohe.utils.HibernateUtiles;
import org.hibernate.Session;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBank{
    Session session = HibernateUtiles.getSession("hibernate.cfg.xml");

    public void s(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }

    /**
     * 查询余额
     */
    @Test
    public void queryAccount() {



        UserServiceImpl userService = new UserServiceImpl();
        userService.setDao(new DaoIpml());

        UserServiceImplProxy userServiceImplProxy = new UserServiceImplProxy();
        userServiceImplProxy.setUserService(userService);
        UserService proxyClass = (UserService) userServiceImplProxy.getProxyClass();


        //将id当做一个唯一的身份证号，根据id查
        User user = new User();
        user.setId(1);
        user.setUname("小贺");
        Acount account = proxyClass.queryAccount(user);
        System.out.println("您的余额为：" + account.getSalary());

        session.close();

    }

    /**
     * 取款
     */
    @Test
    public void getMoney(){

        UserServiceImpl userService = new UserServiceImpl();
        userService.setDao(new DaoIpml());

        UserServiceImplProxy userServiceImplProxy = new UserServiceImplProxy();
        userServiceImplProxy.setUserService(userService);
        UserService proxyClass = (UserService) userServiceImplProxy.getProxyClass();

        User user = new User();
        user.setId(1);
        user.setUname("小贺");

        //取款钱数
        Double money = 10.00;

        //取款前的余额
        Acount oldAccount = proxyClass.queryAccount(user);

        //取款
        boolean b = proxyClass.getMoney(user, money);

        //取款后的余额
        Acount newAccount = proxyClass.queryAccount(user);

        if (b) {
            System.out.println("取款成功，取款前的余额为：" + oldAccount.getSalary() + "元，您取了" + money + "元，" +
                    "您的剩余余额为：" + newAccount.getSalary() + "元。");
        }else {
            System.out.println("取款失败了。");
        }

    }

    /**
     * 存钱
     */
    @Test
    public void addMoney(){



        UserServiceImpl userService = new UserServiceImpl();
        userService.setDao(new DaoIpml());

        UserServiceImplProxy userServiceImplProxy = new UserServiceImplProxy();
        userServiceImplProxy.setUserService(userService);
        UserService proxyClass = (UserService) userServiceImplProxy.getProxyClass();

        User user = new User();
        user.setId(1);
        user.setUname("小贺");

        //存钱钱数
        Double money = 10.00;

        //存钱前的余额
        Acount oldAccount = proxyClass.queryAccount(user);

        //存钱
        boolean b = proxyClass.addMoney(user, money);

        //存钱后的余额
        Acount newAccount = proxyClass.queryAccount(user);

        if (b) {
            System.out.println("存钱成功，存钱前的余额为：" + oldAccount.getSalary() + "元，您存了" + money + "元，" +
                    "您的当前余额为：" + newAccount.getSalary() + "元。");
        }else {
            System.out.println("存钱失败了。");
        }

    }
}

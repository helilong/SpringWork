package com.xiaohe.test;

import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.User;
import com.xiaohe.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSprig{



    @Test
    public void queryAccount() {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user1 = context.getBean("user", User.class);


        //将id当做一个唯一的身份证号，根据id查
        User user = new User();
        user.setId(1);
        user.setUname("小贺");
        Acount account = userService.queryAccount(user);
        System.out.println("您的余额为：" + account.getSalary());


    }

    /**
     * 取款
     */
    @Test
    public void getMoney(){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
        user.setId(1);
        user.setUname("小贺");

        //取款钱数
        Double money = 10.00;

        //取款前的余额
        Acount oldAccount = userService.queryAccount(user);

        //取款
        boolean b = userService.getMoney(user, money);

        //取款后的余额
        Acount newAccount = userService.queryAccount(user);

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

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
        user.setId(1);
        user.setUname("xiaohe");

        //存钱钱数
        Double money = 10.00;

        //存钱前的余额
        Acount oldAccount = userService.queryAccount(user);

        //存钱
        boolean b = userService.addMoney(user, money);

        //存钱后的余额
        Acount newAccount = userService.queryAccount(user);

        if (b) {
            System.out.println("存钱成功，存钱前的余额为：" + oldAccount.getSalary() + "元，您存了" + money + "元，" +
                    "您的当前余额为：" + newAccount.getSalary() + "元。");
        }else {
            System.out.println("存钱失败了。");
        }

    }
}

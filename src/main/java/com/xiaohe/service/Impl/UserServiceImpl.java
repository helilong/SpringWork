package com.xiaohe.service.Impl;

import com.xiaohe.dao.Dao;
import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.User;
import com.xiaohe.service.UserService;

public class UserServiceImpl implements UserService {
    private Dao dao;
    public void setDao(Dao dao) {

        this.dao = dao;
    }
    /*
    查询余额
     */
    public Acount queryAccount(User user) {

        return dao.queryAccount(user);
    }
    /*
    取钱
     */
    public boolean getMoney(User user, Double money) {

        return dao.getMoney(user,money);
    }

    public boolean addMoney(User user, Double money) {

        return dao.addMoney(user,money);
    }
}

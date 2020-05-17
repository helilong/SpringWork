package com.xiaohe.dao;

import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.User;

public interface Dao {
    /**
     * 查询余额
     */
    Acount queryAccount(User user);

    /**
     * 取钱
     */
    boolean getMoney(User user, Double money);

    /**
     * 存钱
     */
    boolean addMoney(User user, Double money);

}

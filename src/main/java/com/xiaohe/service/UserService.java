package com.xiaohe.service;

import com.xiaohe.pojo.Acount;
import com.xiaohe.pojo.User;

public interface UserService {
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

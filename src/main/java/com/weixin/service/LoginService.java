package com.weixin.service;

import com.weixin.bean.User;

import java.sql.SQLException;

public interface LoginService {
    /**
     * 判断登录
     * @param name         账号
     * @param password     密码
     * @return 登录成功，返回user实体，登录失败：返回null
     * @throws SQLException
     */
    User login(String name, String password)throws SQLException;
}


package com.weixin.dao;

import com.weixin.bean.User;

import java.sql.SQLException;


public interface LoginDAO {

    /**
     *根据登录名查询user实体
     *
     * @param name 登录名
     * @return 如果由此用户，返回user实体，如果没有这个用户，返回null
     * @throws SQLException
     */
    User login(String name)throws SQLException;
}


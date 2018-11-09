package com.weixin.dao;

import com.weixin.bean.User;

import java.sql.SQLException;

public interface user_addDao {
    /**
     * 增加用户账号信息
     * @param user
     * @return
     * @throws SQLException
     */
    boolean insert(User user) throws SQLException;
}

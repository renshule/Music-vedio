package com.weixin.servce;

import com.weixin.bean.User;

import java.sql.SQLException;

public interface user_addService {
     boolean insert(User user) throws SQLException;
}

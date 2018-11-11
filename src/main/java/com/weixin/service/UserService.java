package com.weixin.service;

import com.weixin.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> selectAll() throws SQLException;
}

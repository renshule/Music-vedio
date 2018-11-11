package com.weixin.service.serviceimple;

import com.weixin.bean.User;
import com.weixin.dao.UserDao;
import com.weixin.dao.UserDaoImple.UserDaoImple;
import com.weixin.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServceImple implements UserService {
    UserDao userDao = new UserDaoImple();

    @Override
    public List<User> selectAll() throws SQLException {
        return userDao.selectAll();

    }
}

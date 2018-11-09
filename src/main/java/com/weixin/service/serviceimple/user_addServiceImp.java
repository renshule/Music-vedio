package com.weixin.service.serviceimple;

import com.weixin.bean.User;
import com.weixin.dao.UserDaoImple.user_addDaoImp;
import com.weixin.dao.user_addDao;
import com.weixin.servce.user_addService;

import java.sql.SQLException;

public class user_addServiceImp implements user_addService {
    private user_addDao user_addDao = new user_addDaoImp();

    @Override
    public boolean insert(User user) throws SQLException {
        return user_addDao.insert(user);
}
}

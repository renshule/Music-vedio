package com.weixin.dao.UserDaoImple;

import com.weixin.bean.User;
import com.weixin.dao.UserDao;
import com.weixin.util.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImple implements UserDao {


    @Override
    public User login(String name) throws SQLException {
        return C3p0Utils.qr.query("select * from user where name=?",new BeanHandler<>(User.class),name);

    }
}

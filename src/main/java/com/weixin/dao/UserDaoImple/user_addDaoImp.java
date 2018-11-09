package com.weixin.dao.UserDaoImple;

import com.weixin.bean.User;
import com.weixin.dao.user_addDao;
import com.weixin.util.C3p0Utils;

import java.sql.SQLException;

public class user_addDaoImp implements user_addDao {

    @Override
    public boolean insert(User user) throws SQLException {
        return C3p0Utils.qr.update("insert into user values(null,?,?)",user.getU_name(),user.getU_password())>0;
    }
}

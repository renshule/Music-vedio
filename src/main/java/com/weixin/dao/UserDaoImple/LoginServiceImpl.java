package com.weixin.dao.UserDaoImple;

import com.weixin.bean.User;
import com.weixin.dao.LoginDAO;
import com.weixin.service.LoginService;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO = new LoginDAOImpl();

    @Override
    public User login(String name, String password) throws SQLException {
        //先根据name查询用户:
        User user = loginDAO.login(name);
        if(user==null){
            return null;
        }else{
            if(user.getU_password().equals(password)){
                //登录成功:
                return user;
            }
            return null;
        }
    }
}

package com.weixin.dao.UserDaoImple;

import com.weixin.bean.Sing;
import com.weixin.bean.User;
import com.weixin.dao.UserDao;
import com.weixin.util.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImple implements UserDao {


    @Override
    public User login(String name) throws SQLException {
        return C3p0Utils.qr.query("select * from user where name=?",new BeanHandler<>(User.class),name);

    }

    @Override
    public List<User> selectAll() throws SQLException {
        return  C3p0Utils.qr.query("select * from user where u_id>1",new BeanListHandler<>(User.class));
    }

    /**
     * 页面歌曲展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Sing> selectLeftAll() throws SQLException {
        return C3p0Utils.qr.query("SELECT sing_id singId,sing_name singName,sing_pic singPic,singer_name singerName FROM sing s,singer se,classify c WHERE s.singer_id=se.singer_id AND s.`c_id`=c.c_id AND c_name='流行' LIMIT 1,8;",new BeanListHandler<Sing>(Sing.class));
    }

    /**
     * 中间部分的歌曲展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Sing> selectmidAll() throws SQLException {
        return C3p0Utils.qr.query("SELECT sing_id singId,sing_name singName,sing_pic singPic,singer_name singerName FROM sing s,singer se,classify c WHERE s.singer_id=se.singer_id AND s.`c_id`=c.c_id AND c_name='欧美' LIMIT 1,8;",new BeanListHandler<Sing>(Sing.class));
    }


}

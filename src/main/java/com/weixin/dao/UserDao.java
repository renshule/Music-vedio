package com.weixin.dao;

import com.weixin.bean.Sing;
import com.weixin.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     *根据登录名查询user实体
     *
     * @param name 登录名
     * @return 如果由此用户，返回user实体，如果没有这个用户，返回null
     * @throws SQLException
     */
    User login(String name)throws SQLException;
    List<User> selectAll() throws SQLException;

    /**
     * 页面歌曲展示
     * @return
     * @throws SQLException
     */
    List<Sing> selectLeftAll() throws SQLException;

    List<Sing> selectmidAll() throws SQLException;
}

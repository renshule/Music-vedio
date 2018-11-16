package com.weixin.service;

import com.weixin.bean.Ad;
import com.weixin.bean.Sing;
import com.weixin.bean.User;
import com.weixin.bean.UserSing;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> selectAll() throws SQLException;

    /**
     * 页面歌曲列表展示
     * @return
     */
    List<Sing> singListAll() throws SQLException;

    List<Sing> singListAll1() throws SQLException;

    List<Ad> adListAll()throws SQLException;



    Sing selectSing(Integer singId) throws SQLException;


    boolean addUserSing(String singName,Integer u_id)throws SQLException;

    User selectUser(String userName)throws SQLException;

    List<UserSing> userSingListAll(Integer u_id)throws SQLException;
}

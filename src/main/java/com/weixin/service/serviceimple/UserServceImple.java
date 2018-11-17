package com.weixin.service.serviceimple;

import com.weixin.bean.Ad;
import com.weixin.bean.Sing;
import com.weixin.bean.User;
import com.weixin.bean.UserSing;
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

    /**
     * 页面歌曲展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Sing> singListAll() throws SQLException {
        return userDao.selectLeftAll();
    }

    @Override
    public List<Sing> singListAll1() throws SQLException {
        return userDao.selectmidAll();
    }

    @Override
    public List<Ad> adListAll() throws SQLException {
        return userDao.selectRightAll();
    }

    /**
     *
     * 播放记录
     * @param singId
     * @return
     * @throws SQLException
     */
    @Override
    public Sing selectSing(Integer singId) throws SQLException {
        return userDao.selectListSing(singId);
    }

    @Override
    public boolean addUserSing(String singName, Integer u_id) throws SQLException {
        return userDao.insertSingUse(singName,u_id);
    }


    @Override
    public User selectUser(String userName) throws SQLException {
        return userDao.selectListUser(userName);
    }

    @Override
    public List<UserSing> userSingListAll(Integer u_id) throws SQLException {
        return userDao.selectUpdown(u_id);
    }

    /**
     * 搜索歌曲
     * @param singName
     * @return
     * @throws SQLException
     */
    @Override
    public List<Sing> selectSingByName(String singName) throws SQLException {
        return userDao.selectMidList(singName);
    }
}

package com.weixin.dao.UserDaoImple;

import com.weixin.bean.Ad;
import com.weixin.bean.Sing;
import com.weixin.bean.User;
import com.weixin.bean.UserSing;
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
        return C3p0Utils.qr.query("SELECT sing_id singId,sing_name singName,sing_pic singPic,sing_url singUrl,singer_name singerName FROM sing s,singer se,classify c WHERE s.singer_id=se.singer_id AND s.`c_id`=c.c_id AND c_name='流行' LIMIT 1,8;",new BeanListHandler<Sing>(Sing.class));
    }

    /**
     * 中间部分的歌曲展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Sing> selectmidAll() throws SQLException {
        return C3p0Utils.qr.query("SELECT sing_id singId,sing_name singName,sing_pic singPic,sing_url singUrl,singer_name singerName FROM sing s,singer se,classify c WHERE s.singer_id=se.singer_id AND s.`c_id`=c.c_id AND c_name='欧美' LIMIT 1,8;",new BeanListHandler<Sing>(Sing.class));
    }

    /**
     * 右侧广告展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Ad> selectRightAll() throws SQLException {
        return C3p0Utils.qr.query("SELECT ad_id adId,ad_pic adPic,ad_hot adHot,ad_intro adIntro FROM ad  WHERE ad_hot=1 LIMIT 0,4",new BeanListHandler<Ad>(Ad.class));
    }

    @Override
    public Sing selectListSing(Integer singId) throws SQLException {
        return C3p0Utils.qr.query("select sing_name singName from sing where sing_id=?",new BeanHandler<>(Sing.class),singId);
    }

    /**
     * 最近播放列表
     * @param singName
     * @param u_id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insertSingUse(String singName,Integer u_id) throws SQLException {
        return C3p0Utils.qr.update("insert into usersing values(null,?,?)",singName,u_id)>0;
    }

    @Override
    public User selectListUser(String userName) throws SQLException {
        return C3p0Utils.qr.query("select u_id  from user where u_name=?",new BeanHandler<>(User.class),userName);
    }

    @Override
    public List<UserSing> selectUpdown(Integer u_id) throws SQLException {
        return C3p0Utils.qr.query("select DISTINCT Sing_name singName from usersing where u_id=?",new BeanListHandler<>(UserSing.class),u_id);
    }

    /**
     * 搜索歌曲
     * @param singName
     * @return
     * @throws SQLException
     */
    @Override
    public List<Sing> selectMidList(String singName) throws SQLException {
        return C3p0Utils.qr.query("select sing_id singId,sing_name singName,sing_pic singPic,sing_url singUrl,singer_name singerName from sing Sing left join singer Singer on Sing.singer_id=Singer.singer_id where sing_name like ?",new BeanListHandler<>(Sing.class),'%'+singName+'%');
    }


}

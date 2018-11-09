package com.weixin.servce.servceimple;

import com.weixin.bean.Classify;
import com.weixin.bean.Singer;
import com.weixin.dao.AdminDao;
import com.weixin.dao.UserDaoImple.AdminDaoImple;
import com.weixin.servce.AdminServce;

import java.sql.SQLException;
import java.util.List;

public class AdminServceimple implements AdminServce {
    AdminDao ad=new AdminDaoImple();
    @Override
    public List<Classify> ClassifyListAll() throws SQLException {
        return ad.classifyList();
    }

    @Override
    public List<Singer> SingerListAll() throws SQLException {
        return ad.singerListAll();
    }
}

package com.weixin.dao.AdminDaoImple;

import com.weixin.bean.Classify;
import com.weixin.bean.Singer;
import com.weixin.dao.AdminDao;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0utils;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImple implements AdminDao {
    @Override
    public List<Classify> classifyList() throws SQLException {
        return C3P0utils.qr.query("select c_id cId,c_name cName from classify ",new BeanListHandler<Classify>(Classify.class));
    }

    @Override
    public List<Singer> singerListAll() throws SQLException {
        return C3P0utils.qr.query("select singer_id singerId,singer_name singerName,singer_intro singerIntro from singer",new BeanListHandler<Singer>(Singer.class));
    }
}

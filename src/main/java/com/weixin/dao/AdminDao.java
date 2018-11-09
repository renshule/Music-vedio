package com.weixin.dao;

import com.weixin.bean.Classify;
import com.weixin.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    List<Classify> classifyList() throws SQLException;

    List<Singer> singerListAll() throws SQLException;
}

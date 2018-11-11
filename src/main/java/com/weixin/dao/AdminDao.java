package com.weixin.dao;

import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    List<Classify> classifyList() throws SQLException;

    List<Singer> singerListAll() throws SQLException;


    List<Sing> singListAll() throws SQLException;

    boolean removeById(int id) throws SQLException;

    boolean removeAllSings(String[] idsArr)throws SQLException;

    boolean insertSinger(Singer singer)throws SQLException;

    boolean insertSing(Sing sing) throws SQLException;

    Integer selectSingerByNam(String singerName) throws SQLException;
}

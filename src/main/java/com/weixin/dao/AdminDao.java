package com.weixin.dao;

import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    /**
     * 添加列表
     * @return
     * @throws SQLException
     */
    List<Classify> classifyList() throws SQLException;

    List<Singer> singerListAll() throws SQLException;

    List<Sing> singListAll() throws SQLException;

    /**
     * 删除列表
     * @param id
     * @return
     * @throws SQLException
     */

    boolean removeById(int id) throws SQLException;

    boolean removeAllSings(String[] idsArr)throws SQLException;

    /**
     * 增加列表
     * @param singer
     * @return
     * @throws SQLException
     */

    boolean insertSinger(Singer singer)throws SQLException;

    boolean insertSing(Sing sing) throws SQLException;

    Singer selectSingerByNam(String singerName) throws SQLException;

}

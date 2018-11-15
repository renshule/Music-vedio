package com.weixin.dao;

import com.weixin.bean.Ad;
import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    /**
     * 展示列表
     * @return
     * @throws SQLException
     */
    List<Classify> classifyList() throws SQLException;

    List<Singer> singerListAll() throws SQLException;

    List<Sing> singListAll() throws SQLException;
    List<Ad> adSelectAll()throws SQLException;

    /**
     * 删除列表
     * @param id
     * @return
     * @throws SQLException
     */

    boolean removeById(int id) throws SQLException;

    boolean removeAllSings(String[] idsArr)throws SQLException;

    boolean removeByIdAd(int id)throws SQLException;
    /**
     * 增加列表
     * @param singer
     * @return
     * @throws SQLException
     */

    boolean insertSinger(Singer singer)throws SQLException;

    boolean insertSing(Sing sing) throws SQLException;

    Singer selectSingerByNam(String singerName) throws SQLException;

    boolean insertAd(Ad add)throws SQLException;

    /**
     * 修改列表
     * @param add
     * @return
     * @throws SQLException
     */
    boolean updateAdById(Ad add)throws SQLException;

    boolean updateSinger(Singer singer)throws SQLException;

    boolean removeAllAd(String[] idsArr) throws SQLException;

    boolean updateByIdSing(Sing sing) throws SQLException;

    Classify selectCname(int gender)throws SQLException;

    boolean updateClassifyById(Classify classify)throws SQLException;
}

package com.weixin.servce;

import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface AdminServce {
    /**
     * 各个列表的展示
     * @return
     * @throws SQLException
     */
    List<Classify> ClassifyListAll() throws SQLException;

    List<Singer> SingerListAll() throws SQLException;

    List<Sing> SingListAll() throws SQLException;

    /**
     * 列表的删除
     * @param id
     * @return
     * @throws SQLException
     */

    boolean deleteById(int id)throws SQLException;

    boolean removeAllSings(String[] idsArr)throws SQLException;

    /**
     * 列表的添加
     * @param singer
     * @return
     * @throws SQLException
     */

    boolean insertSinger(Singer singer)throws SQLException;


    boolean insertSing(Sing sing)throws SQLException;

    boolean selectSingerByName(String singerName) throws SQLException;

    Integer selectSingerByNames(String singerName)throws SQLException;
}

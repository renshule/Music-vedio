package com.weixin.servce;

import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface AdminServce {
    List<Classify> ClassifyListAll() throws SQLException;

    List<Singer> SingerListAll() throws SQLException;




    List<Sing> SingListAll() throws SQLException;

    boolean deleteById(int id)throws SQLException;

    boolean removeAllSings(String[] idsArr)throws SQLException;

    boolean insertSinger(Singer singer)throws SQLException;

    boolean insertSing(Sing sing)throws SQLException;
}

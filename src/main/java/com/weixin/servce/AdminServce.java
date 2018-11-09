package com.weixin.servce;

import com.weixin.bean.Classify;
import com.weixin.bean.Singer;

import java.sql.SQLException;
import java.util.List;

public interface AdminServce {
    List<Classify> ClassifyListAll() throws SQLException;

    List<Singer> SingerListAll() throws SQLException;
}

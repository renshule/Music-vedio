package com.weixin.dao.AdminDaoImple;

import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;
import com.weixin.dao.AdminDao;
import com.weixin.util.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.C3P0utils;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImple implements AdminDao {
    /**
     *分类列表展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Classify> classifyList() throws SQLException {
        return C3P0utils.qr.query("select c_id cId,c_name cName from classify ",new BeanListHandler<Classify>(Classify.class));
    }

    /**
     * 歌手列表展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Singer> singerListAll() throws SQLException {
        return C3P0utils.qr.query("select singer_id singerId,singer_name singerName,singer_intro singerIntro from singer",new BeanListHandler<Singer>(Singer.class));
    }


    /**
     * 歌曲展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Sing> singListAll() throws SQLException {
        return C3P0utils.qr.query("select sing_id singId,sing_name singName,sing_pic singPic,sing_url singUrl,singer_name singerName FROM sing s LEFT JOIN singer se ON s.singer_id=se.singer_id",new BeanListHandler<Sing>(Sing.class));
    }

    /**
     * 删除某个歌曲
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean removeById(int id) throws SQLException {
        return C3p0Utils.qr.update("delete from sing where sing_id=?",id)>0;
    }

    /**
     * 删除所选歌曲
     * @param idsArr
     * @return
     * @throws SQLException
     */
    @Override
    public boolean removeAllSings(String[] idsArr) throws SQLException {
        StringBuffer sql = new StringBuffer("delete from sing where sing_id in (");
        for(int i=0;i<idsArr.length;i++){
            sql.append("?,");
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        return C3P0utils.qr.update(sql.toString(),idsArr)>0;
    }

    /**
     * 添加歌手
     * @param singer
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insertSinger(Singer singer) throws SQLException {
        return C3p0Utils.qr.update("insert into singer values(null,?,?)",singer.getSingerName(),singer.getSingerIntro())>0;
    }

    /**
     * 添加歌曲
     * @param sing
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insertSing(Sing sing) throws SQLException {
        return C3p0Utils.qr.update("insert into sing values(null,?,?,null,?,null)",sing.getSingName(),sing.getSingPic(),sing.getCId())>0;
    }

    /**
     * 在添加歌曲时查找判断歌手与上一个一起联合用
     * @param singerName
     * @return
     * @throws SQLException
     */
    @Override
    public Integer selectSingerByNam(String singerName) throws SQLException {
        return C3p0Utils.qr.query("select singer_id from singer where singer_name=?",new ScalarHandler<Long>()).intValue();
    }
}

package com.weixin.dao.AdminDaoImple;

import com.weixin.bean.Ad;
import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;
import com.weixin.dao.AdminDao;
import com.weixin.util.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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
        return C3P0utils.qr.query("SELECT sing_id singId,sing_name singName,sing_pic singPic,sing_url singUrl,c.c_id cId,c_name cName,se.`singer_id` singerId,singer_name singerName FROM sing s,singer se,classify c WHERE s.singer_id=se.singer_id AND s.`c_id`=c.c_id",new BeanListHandler<Sing>(Sing.class));
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
        return C3p0Utils.qr.update("insert into sing values(null,?,?,?,?,?)",sing.getSingName(),sing.getSingPic(),sing.getSingUrl(),sing.getCId(),sing.getSingerId())>0;
    }

    /**
     * 在添加歌曲时查找判断歌手与上一个一起联合用
     * @param singerName
     * @return
     * @throws SQLException
     */
    @Override
    public Singer selectSingerByNam(String singerName) throws SQLException {
        return C3p0Utils.qr.query("select singer_id singerId,singer_name singerName from singer where singer_name=?",new BeanHandler<>(Singer.class),singerName);
    }

    /**
     * 广告表展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Ad> adSelectAll() throws SQLException {
        return C3p0Utils.qr.query("select ad_id adId,ad_pic adPic,ad_hot adHot,ad_intro adIntro from ad",new BeanListHandler<>(Ad.class));
    }

    /**
     * 广告表添加
     * @param add
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insertAd(Ad add) throws SQLException {
        return C3p0Utils.qr.update("insert into ad values(null,?,?,?)",add.getAdPic(),add.getAdHot(),add.getAdIntro())>0;
    }

    /**
     * 广告表修改
     * @param add
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateAdById(Ad add) throws SQLException {
        return C3p0Utils.qr.update("update ad Ad set ad_pic=?,ad_hot=?,ad_intro=? where ad_id=?",add.getAdPic(),add.getAdHot(),add.getAdIntro(),add.getAdId())>0;
    }

    /**
     * 广告表根据id删除
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean removeByIdAd(int id) throws SQLException {
        return C3p0Utils.qr.update("delete from ad where ad_id=?",id)>0;
    }

    /**
     * 歌手表修改
     * @param singer
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateSinger(Singer singer) throws SQLException {
        return C3p0Utils.qr.update("update singer Singer set singer_name=?,singer_intro=? where singer_id=?",singer.getSingerName(),singer.getSingerIntro(),singer.getSingerId())>0;
    }

    /**
     * 广告页面删除所选
     * @param idsArr
     * @return
     * @throws SQLException
     */
    @Override
    public boolean removeAllAd(String[] idsArr) throws SQLException {
        StringBuffer sql = new StringBuffer("delete from ad where ad_id in (");
        for(int i=0;i<idsArr.length;i++){
            sql.append("?,");
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        return C3P0utils.qr.update(sql.toString(),idsArr)>0;
    }

    /**
     * 歌曲表修改
     * @param sing
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateByIdSing(Sing sing) throws SQLException {
        return C3p0Utils.qr.update("update sing Sing set sing_name=?,sing_pic=?,sing_url=?,c_id=?,singer_id=? where sing_id=?",sing.getSingName(),sing.getSingPic(),sing.getSingUrl(),sing.getCId(),sing.getSingerId(),sing.getSingId())>0;
    }

    /**
     * 歌曲修改列表中的一部分  获取歌手名称
     * @param gender
     * @return
     * @throws SQLException
     */
    @Override
    public Classify selectCname(int gender) throws SQLException {
        return C3p0Utils.qr.query("select c_id cId,c_name cName from classify where c_id=?",new BeanHandler<>(Classify.class),gender);
    }

    /**
     * 分类表修改
     * @param classify
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateClassifyById(Classify classify) throws SQLException {
        return C3p0Utils.qr.update("update classify Classify set c_name=? where c_id=?",classify.getCName(),classify.getCId())>0;
    }
}

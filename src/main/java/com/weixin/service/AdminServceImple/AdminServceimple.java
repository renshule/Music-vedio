package com.weixin.servce.servceimple;

import com.weixin.bean.Ad;
import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;
import com.weixin.dao.AdminDao;
import com.weixin.dao.AdminDaoImple.AdminDaoImple;
import com.weixin.servce.AdminServce;

import java.sql.SQLException;
import java.util.List;

public class AdminServceimple implements AdminServce {
    AdminDao ad=new AdminDaoImple();

    /**
     *  歌曲分类列表展示
     * @return 分类列表集合
     * @throws SQLException
     */
    @Override
    public List<Classify> ClassifyListAll() throws SQLException {
        return ad.classifyList();
    }

    /**
     *  歌手列表展示
     * @return 返回歌手列表集合
     * @throws SQLException
     */
    @Override
    public List<Singer> SingerListAll() throws SQLException {
        return ad.singerListAll();
    }

    /**
     *  歌曲列表展示
     * @return 歌曲列表集合
     * @throws SQLException
     */
    @Override
    public List<Sing> SingListAll() throws SQLException {
        return ad.singListAll();
    }

    /**
     *  根据id删除表中的某一列
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean deleteById(int id) throws SQLException {
        return ad.removeById(id);
    }

    /**
     *  删除所选
     * @param idsArr
     * @return 返回真假
     * @throws SQLException
     */
    @Override
    public boolean removeAllSings(String[] idsArr) throws SQLException {
        return ad.removeAllSings(idsArr);
    }

    /**
     *  添加歌手
     * @param singer
     * @return 返回是否添加成功
     * @throws SQLException
     */
    @Override
    public boolean insertSinger(Singer singer) throws SQLException {
        return ad.insertSinger(singer);
    }

    /**
     *  添加歌曲
     * @param sing
     * @return 返回是否添加成功
     * @throws SQLException
     */
    @Override
    public boolean insertSing(Sing sing) throws SQLException {
        return ad.insertSing(sing);
    }

    /**
     *  歌曲添加列表中的一个部分判断，判断是否存在这个歌手
     * @param singerName
     * @return 返回真假值
     * @throws SQLException
     */
    @Override
    public boolean selectSingerByName(String singerName) throws SQLException {
        Singer singer = ad.selectSingerByNam(singerName);
        if(singer==null){
            return false;
        }else {
            return true;
        }
    }

    /**
     *  添加歌曲列表中的一部分 根据名称获取到歌手的id
     * @param singerName
     * @return
     * @throws SQLException
     */
    @Override
    public Integer selectSingerByNames(String singerName) throws SQLException{
        Integer singerId = ad.selectSingerByNam(singerName).getSingerId();
        System.out.println(singerId);
        return singerId;
    }

    /**
     * 广告表展示
     * @return
     * @throws SQLException
     */
    @Override
    public List<Ad> adAll() throws SQLException {
        return ad.adSelectAll();
    }

    /**
     * 广告表添加
     * @param add
     * @return
     * @throws SQLException
     */
    @Override
    public boolean addAd(Ad add) throws SQLException {
        return ad.insertAd(add);
    }

    /**
     *广告表修改
     * @param add
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateAd(Ad add) throws SQLException {
        return ad.updateAdById(add);
    }

    /**
     *广告表删除
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean deleteByIdAd(int id) throws SQLException {
        return ad.removeByIdAd(id);
    }

    /**
     * 歌手表修改
     * @param singer
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateSinger(Singer singer) throws SQLException {
        return ad.updateSinger(singer);
    }

    /**
     * 广告列表删除所选
     * @param idsArr
     * @return
     * @throws SQLException
     */
    @Override
    public boolean removeAllAd(String[] idsArr) throws SQLException {
        return ad.removeAllAd(idsArr);
    }

    /**
     * 修改歌曲列表
     * @param sing
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateSing(Sing sing) throws SQLException {
        return ad.updateByIdSing(sing);
    }

    /**
     * 修改歌曲列表中的一个分支，用来获取到歌手的名称
     * @param gender
     * @return
     * @throws SQLException
     */
    @Override
    public String selectSingByC(int gender) throws SQLException {
        return ad.selectCname(gender).getCName();
    }

    @Override
    public boolean updateClassify(Classify classify) throws SQLException {
        return ad.updateClassifyById(classify);
    }



}

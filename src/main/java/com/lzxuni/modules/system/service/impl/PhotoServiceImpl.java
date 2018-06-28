
package com.lzxuni.modules.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.entity.zlzs.PhotoCustom;
import com.lzxuni.modules.system.mapper.PhotoMapper;
import com.lzxuni.modules.system.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * MachiningServiceImpl
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-28 16:43
 * @description 
 **/
@Service("photoService")
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public PageInfo<Photo> queryPage(PageParameter pageParameter, Photo demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Photo> roleList = photoMapper.selectList(new EntityWrapper<Photo>(demo));
        PageInfo<Photo> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Photo> queryList(Photo demo){
        return photoMapper.selectList(new EntityWrapper<Photo>());
    }


    @Override
    public PageInfo<PhotoCustom> queryListPhtotAndQszqtp(PageParameter pageParameter, PhotoCustom demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<PhotoCustom> roleList = null;
        try {
            roleList = photoMapper.queryListPhtotAndQszqtp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PageInfo<PhotoCustom> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }


}

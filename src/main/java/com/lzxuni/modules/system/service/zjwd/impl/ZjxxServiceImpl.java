
package com.lzxuni.modules.system.service.zjwd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zjwd.Zjxx;
import com.lzxuni.modules.system.entity.zjwd.ZjxxCustom;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.entity.zlzs.PhotoCustom;
import com.lzxuni.modules.system.mapper.PhotoMapper;
import com.lzxuni.modules.system.mapper.zjwd.ZjxxMapper;
import com.lzxuni.modules.system.service.PhotoService;
import com.lzxuni.modules.system.service.zjwd.ZjxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * MachiningServiceImpl
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-29 16:43
 * @description 
 **/
@Service("zjxxService")
public class ZjxxServiceImpl extends ServiceImpl<ZjxxMapper, Zjxx> implements ZjxxService {
    @Autowired
    private ZjxxMapper zjxxMapper;

    @Override
    public PageInfo<Zjxx> queryPage(PageParameter pageParameter, Zjxx demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Zjxx> roleList = zjxxMapper.selectList(new EntityWrapper<Zjxx>(demo));
        PageInfo<Zjxx> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Zjxx> queryList(Zjxx demo){
        return zjxxMapper.selectList(new EntityWrapper<Zjxx>());
    }


    @Override
    public PageInfo<ZjxxCustom> queryListPhtotAndQszqtp(PageParameter pageParameter, ZjxxCustom demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<ZjxxCustom> roleList = null;
        try {
            roleList = zjxxMapper.queryListPhtotAndQszqtp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PageInfo<ZjxxCustom> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }


}

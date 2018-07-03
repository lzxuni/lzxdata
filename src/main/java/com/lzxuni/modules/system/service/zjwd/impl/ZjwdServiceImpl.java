
package com.lzxuni.modules.system.service.zjwd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zjwd.Zjwd;
import com.lzxuni.modules.system.entity.zjwd.ZjwdCustom;
import com.lzxuni.modules.system.entity.zjwd.Zjxx;
import com.lzxuni.modules.system.entity.zjwd.ZjxxCustom;
import com.lzxuni.modules.system.mapper.zjwd.ZjwdMapper;
import com.lzxuni.modules.system.mapper.zjwd.ZjxxMapper;
import com.lzxuni.modules.system.service.zjwd.ZjwdService;
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
@Service("zjwdService")
public class ZjwdServiceImpl extends ServiceImpl<ZjwdMapper, Zjwd> implements ZjwdService {
    @Autowired
    private ZjwdMapper zjwdMapper;

    @Override
    public PageInfo<Zjwd> queryPage(PageParameter pageParameter, Zjwd demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Zjwd> roleList = zjwdMapper.selectList(new EntityWrapper<Zjwd>(demo));
        PageInfo<Zjwd> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Zjwd> queryList(Zjwd demo){
        return zjwdMapper.selectList(new EntityWrapper<Zjwd>());
    }


//    @Override
//    public PageInfo<ZjwdCustom> queryListPhtotAndQszqtp(PageParameter pageParameter, ZjwdCustom demo) {
//        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
//                pageParameter.getSidx() + " " + pageParameter.getSord());
//        List<ZjwdCustom> roleList = null;
//        try {
//            roleList = zjwdMapper.queryListPhtotAndQszqtp();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        PageInfo<ZjwdCustom> pageInfo = new PageInfo<>(roleList);
//        return pageInfo;
//    }


}

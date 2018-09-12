
package com.lzxuni.modules.system.service.zjwd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.zjwd.Nztj;
import com.lzxuni.modules.system.entity.zjwd.Zjwd;
import com.lzxuni.modules.system.mapper.zjwd.NztjMapper;
import com.lzxuni.modules.system.mapper.zjwd.ZjwdMapper;
import com.lzxuni.modules.system.service.zjwd.NztjService;
import com.lzxuni.modules.system.service.zjwd.ZjwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MachiningServiceImpl
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-29 16:43
 * @description 
 **/
@Service("nztjService")
public class NztjServiceImpl extends ServiceImpl<NztjMapper, Nztj> implements NztjService {
    @Autowired
    private NztjMapper nztjMapper;

    @Override
    public PageInfo<Nztj> queryPage(PageParameter pageParameter, Nztj demo) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Nztj> roleList = nztjMapper.selectList(new EntityWrapper<Nztj>(demo));
        PageInfo<Nztj> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Nztj> queryList(Nztj demo){
        return nztjMapper.selectList(new EntityWrapper<Nztj>());
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

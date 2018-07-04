package com.lzxuni.modules.system.service.nydsj.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.nydsj.Zhsj;
import com.lzxuni.modules.system.mapper.nydsj.ZhsjMapper;
import com.lzxuni.modules.system.service.nydsj.ZhsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("zhsjService")
public class ZhsjServiceImpl extends ServiceImpl<ZhsjMapper,Zhsj> implements ZhsjService {
    @Autowired
    private ZhsjMapper zhsjMapper;
    @Override
    public PageInfo<Zhsj> queryPage(PageParameter pageParameter, Zhsj zhsj) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows()).setOrderBy(
                pageParameter.getSidx() + " " + pageParameter.getSord());
        List<Zhsj> zhsjList;
        if(zhsj.getHumidity()!=null){
            zhsjList=zhsjMapper.findmuhuZhsj(zhsj);
        }else {
            zhsjList = zhsjMapper.queryList(zhsj);
        }
        PageInfo<Zhsj> pageInfo = new PageInfo<>(zhsjList);
        return pageInfo;
    }
}

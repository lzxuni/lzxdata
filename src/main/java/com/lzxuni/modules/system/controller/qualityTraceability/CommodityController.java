package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.*;
import com.lzxuni.modules.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * CommodityController
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-21
 * @description 
 **/
@RestController
@RequestMapping("/admin/ht/commodity")
public class CommodityController extends BaseController {

    @Autowired
    private CommodityService commodityService;

    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/commodity/index");
        return mv;
    }
    // 列表
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String queryJson) throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Commodity demo = JSON.parseObject(queryJson, Commodity.class);
        if (demo == null) {
            demo = new Commodity();
        }
        PageData pageData = getPageData(commodityService.queryPage(pageParameter, demo));
        return R.ok(pageData);
    }
    // 新增,修改
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception{
        ModelAndView mv = new ModelAndView("/ht/commodity/Form");
        return mv;
    }
    // 新增,修改 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(Commodity demo) throws Exception {

        if(StringUtils.isEmpty(demo.getId())){
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            commodityService.insert(demo);
            return R.ok("新增成功");
        }else{
            commodityService.updateById(demo);
            return R.ok("修改成功");
        }
    }
    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue")String[] roleIds){
        commodityService.deleteBatchIds(Arrays.asList(roleIds));
        return  R.ok("删除成功");
    }
}

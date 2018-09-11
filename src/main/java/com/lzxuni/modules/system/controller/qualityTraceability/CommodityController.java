package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileEntityService;
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
    @Autowired
    private FileEntityService fileEntityService;
    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/commodity/index");
        return mv;
    }
    // 列表
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String cname) throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
//        Commodity demo = JSON.parseObject(cname, Commodity.class);
//        if (demo == null) {
//            demo = new Commodity();
//        }
        Commodity demo=new Commodity();
        demo.setCname(cname);
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
    public Object insertDo(Commodity demo,String tts) throws Exception {
        String ids=demo.getId();
        System.out.println("ids-----------"+ids);

         if(ids.length()>1){
            ids=ids.split(",")[0];
        }else{
            ids=null;
        }
        if(tts.length()<10){
            tts=null;
        }
        demo.setId(ids);
        if(StringUtils.isEmpty(ids)){
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            fileEntityService.insert(tts,demo.getId(),"商品图片","commoditytp",demo.getCname());
            commodityService.insert(demo);
            return R.ok("新增成功");
        }else{
            fileEntityService.deleteByYwId(demo.getId());
            fileEntityService.insert(tts,demo.getId(),"商品图片","commoditytp",demo.getCname());

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
    // 商品列表
    @RequestMapping("/GetList.html")
    public Object queryListByParentId() throws Exception {
        List<Commodity> commodityList = commodityService.queryList(new Commodity());
        return R.ok(commodityList);

    }
}

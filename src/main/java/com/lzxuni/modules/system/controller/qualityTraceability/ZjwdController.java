package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileBeanService;
import com.lzxuni.modules.common.service.FileEntityService;
import com.lzxuni.modules.system.entity.zjwd.Zjwd;
import com.lzxuni.modules.system.entity.zjwd.ZjwdCustom;
import com.lzxuni.modules.system.service.zjwd.ZjwdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;

/**
 * ZjwdController
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-28
 * @description 
 **/
@RestController
@RequestMapping("/admin/ht/zjwd")
public class ZjwdController extends BaseController {

    @Autowired
    private ZjwdService zjwdService;
    @Autowired
    private FileEntityService fileEntityService;

    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/zjwd/index");
        return mv;
    }

    // 列表
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String cname) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);

        Zjwd demo = new Zjwd();
        //demo.setCommodityid(cname);
        //PageData pageData = getPageData(photoService.queryPage(pageParameter, demo));
        PageData pageData = getPageData(zjwdService.queryPage(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,修改
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/zjwd/Form");
        return mv;
    }


    // 新增,修改 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(Zjwd demo,String tts) throws Exception {
        System.out.println(demo.getId()+"------demo.getId()");
        System.out.println("tts----------"+tts);
        String ids=demo.getId();
        if(ids.length()>32){
            ids=ids.split(",")[0];
        }else{
            ids=null;
        }
        demo.setId(ids);
        System.out.println("ids-----------"+ids);

        if(StringUtils.isEmpty(ids)){
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            fileEntityService.insert(tts,demo.getId(),"问题图片","wttp","问题图片");
            zjwdService.insert(demo);
            return R.ok("新增成功");
        }else{
            fileEntityService.deleteByYwId(demo.getId());
            fileEntityService.insert(tts,demo.getId(),"问题图片","wttp","问题图片");
            zjwdService.updateById(demo);
            return R.ok("修改成功");
        }
    }



    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        zjwdService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


}



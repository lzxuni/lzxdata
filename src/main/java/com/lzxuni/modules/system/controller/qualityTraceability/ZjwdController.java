package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileBeanService;
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
 * MachiningController
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
    private FileBeanService fileBeanService;

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

        ZjwdCustom demo = new ZjwdCustom();
        //demo.setCommodityid(cname);
        //PageData pageData = getPageData(photoService.queryPage(pageParameter, demo));
        PageData pageData = getPageData(zjwdService.queryListPhtotAndQszqtp(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/zjwd/Form");
        return mv;
    }

    // 修改
    @RequestMapping("/update_v.html")
    public ModelAndView update() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/zjwd/Form1");
        return mv;
    }

    // 新增, 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(ZjwdCustom zjwdCustom,String tts) throws Exception {
        System.out.println(zjwdCustom.toString());
        System.out.println("tts----------"+tts);
        Zjwd demo = new Zjwd();
        demo.setId(UuidUtil.get32UUID());
        demo.setCreatetime(new Date());
        //fileBeanService.insertFileBean(zjwdCustom.getWttp(), demo.getId(), "问题图片", "wttp");
        fileBeanService.insertFileBean(tts, demo.getId(), "问题图片", "wttp");

        demo.setWttitle(zjwdCustom.getWttitle());
        demo.setWtneirong(zjwdCustom.getWtneirong());
        demo.setZjid(zjwdCustom.getZjid());
        demo.setZjanswer(zjwdCustom.getZjanswer());
        demo.setZhuiwen(zjwdCustom.getZhuiwen());
        demo.setZhuida(zjwdCustom.getZhuida());

        zjwdService.insert(demo);
        return R.ok("新增成功");

    }

    // 修改 处理
    @RequestMapping("/update_o.html")
    public Object updateDo(ZjwdCustom zjwdCustom) throws Exception {
        System.out.println(zjwdCustom.toString());
        System.out.println("zjxxCustom.getQszqtpupdate()------"+zjwdCustom.getWttpupdate());
        if (zjwdCustom.getWttpupdate() != null ) {
            fileBeanService.delFileBean(zjwdCustom.getId());
            fileBeanService.insertFileBean(zjwdCustom.getWttpupdate(), zjwdCustom.getId(), "问题图片", "wttp");

        }
        Zjwd demo = new Zjwd();
        demo.setId(zjwdCustom.getId());
        demo.setCreatetime(zjwdCustom.getCreatetime());
        demo.setWttitle(zjwdCustom.getWttitle());
        demo.setWtneirong(zjwdCustom.getWtneirong());
        demo.setZjid(zjwdCustom.getZjid());
        demo.setZjanswer(zjwdCustom.getZjanswer());
        demo.setZhuiwen(zjwdCustom.getZhuiwen());
        demo.setZhuida(zjwdCustom.getZhuida());
        zjwdService.updateById(demo);
        return R.ok("修改成功");
    }

    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        zjwdService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


}



package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.Fertilizer;
import com.lzxuni.modules.system.entity.Machining;
import com.lzxuni.modules.system.service.FertilizerService;
import com.lzxuni.modules.system.service.MachiningService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * MachiningController
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-27
 * @description 
 **/
@RestController
@RequestMapping("/admin/ht/fertilizer")
public class FertilizerController extends BaseController {

    @Autowired
    private FertilizerService fertilizerService;

    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/fertilizer/index");
        return mv;
    }

    // 列表
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String cname) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
//        Commodity demo = JSON.parseObject(cname, Commodity.class);
//        if (demo == null) {
//            demo = new Commodity();
//        }
        Fertilizer demo = new Fertilizer();
        demo.setCommodityid(cname);
        PageData pageData = getPageData(fertilizerService.queryPage(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,修改
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/fertilizer/Form");
        return mv;
    }

    // 新增,修改 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(Fertilizer demo) throws Exception {

        if (StringUtils.isEmpty(demo.getId())) {
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            fertilizerService.insert(demo);
            return R.ok("新增成功");
        } else {
            fertilizerService.updateById(demo);
            return R.ok("修改成功");
        }
    }

    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        fertilizerService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


}



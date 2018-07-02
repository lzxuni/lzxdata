package com.lzxuni.modules.system.controller.AgriculturalEncyclopedia;


import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.AgriculturalEncyclopedia.AgriculturalEncyclopedia;
import com.lzxuni.modules.system.service.AgriculturalEncyclopedia.AgriculturalEncyclopediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/AgriculturalEncyclopedia")
public class AgriculturalEncyclopediaController extends BaseController {
    @Autowired
    AgriculturalEncyclopediaService agriculturalEncyclopediaService;

    @RequestMapping("/AgriculturalEncyclopedia.html")
    public ModelAndView GrainYield() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalEncyclopedia/AgriculturalEncyclopedia");
        return mv;
    }

    // 列表
    @RequestMapping("/listAgriculturalEncyclopedia.html")
    public Object listGrainYield(String pagination,
                                 String type) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        AgriculturalEncyclopedia agriculturalEncyclopedia = new AgriculturalEncyclopedia();
        PageData pageData = getPageData(agriculturalEncyclopediaService.queryPage(pageParameter, agriculturalEncyclopedia));
        return R.ok(pageData);
    }

    @RequestMapping("/addAgriculturalEncyclopedia.html")
    public ModelAndView addGrainYield() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalEncyclopedia/formAgriculturalEncyclopedia");
        return mv;
    }

    @RequestMapping("/addAgriculturalEncyclopediaDo.html")
    public Object addGrainYieldDo(AgriculturalEncyclopedia agriculturalEncyclopedia) {
        if (StringUtils.isEmpty(agriculturalEncyclopedia.getId())) {
            agriculturalEncyclopedia.setId(UuidUtil.get32UUID());
            Date date = new Date();
            agriculturalEncyclopedia.setCreatetime(date);
            System.out.println(agriculturalEncyclopedia.getContent());
            agriculturalEncyclopediaService.insert(agriculturalEncyclopedia);
            return R.ok("新增成功");
        } else {
            agriculturalEncyclopediaService.updateById(agriculturalEncyclopedia);
            return R.ok("修改成功");
        }
    }

    //删除
    @RequestMapping("/deleteAgriculturalEncyclopediaDo.html")
    public Object deleteGrainYieldDo(@RequestParam("keyValue") String[] roleIds) {
        agriculturalEncyclopediaService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
}
package com.lzxuni.modules.system.controller;

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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * QualityTraceabilityController
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-21 16:19
 * @description 
 **/
@RestController
@RequestMapping("/admin/qt/qualityTraceability")
public class QualityTraceabilityController extends BaseController {

    @Autowired
    private RoleService roleService;


    // 质量追溯
    @RequestMapping("/zlzs.html")
    public ModelAndView zlzs() {
        ModelAndView mv = new ModelAndView("/qt/zlzs");




        return mv;
    }

}

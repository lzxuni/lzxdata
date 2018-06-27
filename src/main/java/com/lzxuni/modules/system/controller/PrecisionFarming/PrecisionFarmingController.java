package com.lzxuni.modules.system.controller.PrecisionFarming;


import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.controller.GrainYield;
import com.lzxuni.modules.system.entity.PrecisionFarming.PrecisionFarming;
import com.lzxuni.modules.system.service.PrecisionFarming.PrecisionFarmingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/PrecisionFarming")
public class PrecisionFarmingController extends BaseController {
    @Autowired
    PrecisionFarmingService precisionFarmingService;

    @RequestMapping("/PrecisionFarming.html")
    public ModelAndView GrainYield() {
        ModelAndView mv = new ModelAndView("/admin/PrecisionFarming/PrecisionFarming");
        return mv;
    }

    // 列表
    @RequestMapping("/listPrecisionFarming.html")
    public Object listGrainYield(String pagination,
                                 String type) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        PrecisionFarming precisionFarming = new PrecisionFarming();
        PageData pageData = getPageData(precisionFarmingService.queryPage(pageParameter, precisionFarming));
        return R.ok(pageData);
    }

    @RequestMapping("/addPrecisionFarming.html")
    public ModelAndView addGrainYield() {
        ModelAndView mv = new ModelAndView("/admin/PrecisionFarming/formPrecisionFarming");
        return mv;
    }

    @RequestMapping("/addPrecisionFarmingDo.html")
    public Object addGrainYieldDo(PrecisionFarming precisionFarming) {
        if (StringUtils.isEmpty(precisionFarming.getId())) {
            precisionFarming.setId(UuidUtil.get32UUID());
            Date date = new Date();
            precisionFarming.setCreatetime(date);
            precisionFarming.setTime(new SimpleDateFormat("yyMMddhhmmss").format(date));
            precisionFarmingService.insert(precisionFarming);
            return R.ok("新增成功");
        } else {
            precisionFarmingService.updateById(precisionFarming);
            return R.ok("修改成功");
        }
    }

    //删除
    @RequestMapping("/deletePrecisionFarmingDo.html")
    public Object deleteGrainYieldDo(@RequestParam("keyValue") String[] roleIds) {
        precisionFarmingService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
}
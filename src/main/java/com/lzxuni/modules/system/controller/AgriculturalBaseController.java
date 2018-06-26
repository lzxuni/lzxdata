package com.lzxuni.modules.system.controller;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.system.entity.GrainSales;
import com.lzxuni.modules.system.entity.PlantArea;
import com.lzxuni.modules.system.entity.PlantType;
import com.lzxuni.modules.system.service.agriculturalBase.GrainSalesService;
import com.lzxuni.modules.system.service.agriculturalBase.GrainYieldService;
import com.lzxuni.modules.system.service.agriculturalBase.PlantAreaService;
import com.lzxuni.modules.system.service.agriculturalBase.PlantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;


@RestController
@RequestMapping("/agriculturalbase")
public class AgriculturalBaseController extends BaseController {
    @Autowired
    PlantAreaService plantAreaService;
    @Autowired
    PlantTypeService plantTypeService;
    @Autowired
    GrainSalesService grainSalesService;
    @Autowired
    GrainYieldService grainYieldService;

    @RequestMapping("/area.html")
    public ModelAndView area() {
//        List<PlantArea> plantAreas = plantAreaService.selectList(new EntityWrapper<PlantArea>());
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/area");
//        mv.addObject("List", plantAreas);
        return mv;
    }

    // 列表
    @RequestMapping("/listArea.html")
    public Object index_o(String pagination,
                          String type) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        PlantArea plantAreas = new PlantArea();
        PageData pageData = getPageData(plantAreaService.queryPage(pageParameter, plantAreas));
        return R.ok(pageData);
    }

    @RequestMapping("/addArea.html")
    public ModelAndView addArea() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/formArea");
        return mv;
    }

    @RequestMapping("/addAreaDo.html")
    public Object addAreaDo(PlantArea plantArea) {
        if (StringUtils.isEmpty(plantArea.getId())) {
            plantArea.setId(UuidUtil.get32UUID());
            plantArea.setCreatetime(new Date());
            plantAreaService.insert(plantArea);
            return R.ok("新增成功");
        } else {
            plantAreaService.updateById(plantArea);
            return R.ok("修改成功");
        }
    }

    //删除
    @RequestMapping("/deleteAreaDo.html")
    public Object deleteDo(@RequestParam("keyValue") String[] roleIds) {
        plantAreaService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }

    @RequestMapping("/type.html")
    public ModelAndView type() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/type");
        return mv;
    }

    // 列表
    @RequestMapping("/listType.html")
    public Object listType(String pagination,
                           String type) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        PlantType plantType = new PlantType();
        plantType.setType(type);
        PageData pageData = getPageData(plantTypeService.queryPage(pageParameter, plantType));
        return R.ok(pageData);
    }

    @RequestMapping("/addType.html")
    public ModelAndView addType() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/formType");
        return mv;
    }

    @RequestMapping("/addTypeDo.html")
    public Object addTypeDo(PlantType plantType) {
        if (StringUtils.isEmpty(plantType.getId())) {
            plantType.setId(UuidUtil.get32UUID());
            plantType.setCreatetime(new Date());
            plantTypeService.insert(plantType);
            return R.ok("新增成功");
        } else {
            plantTypeService.updateById(plantType);
            return R.ok("修改成功");
        }
    }

    //删除
    @RequestMapping("/deleteTypeDo.html")
    public Object deleteTypeDo(@RequestParam("keyValue") String[] roleIds) {
        plantTypeService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }

    @RequestMapping("/GrainSales.html")
    public ModelAndView GrainSales() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/GrainSales");
        return mv;
    }

    // 列表
    @RequestMapping("/listGrainSales.html")
    public Object listGrainSales(String pagination,
                                 String type) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        GrainSales grainSales = new GrainSales();
        grainSales.setType(type);
        PageData pageData = getPageData(grainSalesService.queryPage(pageParameter, grainSales));
        return R.ok(pageData);
    }

    @RequestMapping("/addGrainSales.html")
    public ModelAndView addGrainSales() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/formGrainSales");
        return mv;
    }

    @RequestMapping("/addGrainSalesDo.html")
    public Object addGrainSalesDo(GrainSales grainSales) {
        if (StringUtils.isEmpty(grainSales.getId())) {
            grainSales.setId(UuidUtil.get32UUID());
            grainSales.setCreatetime(new Date());
            grainSalesService.insert(grainSales);
            return R.ok("新增成功");
        } else {
            grainSalesService.updateById(grainSales);
            return R.ok("修改成功");
        }
    }

    //删除
    @RequestMapping("/deleteGrainSalesDo.html")
    public Object deleteGrainSalesDo(@RequestParam("keyValue") String[] roleIds) {
        grainSalesService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


    @RequestMapping("/GrainYield.html")
    public ModelAndView GrainYield() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/GrainYield");
        return mv;
    }

    // 列表
    @RequestMapping("/listGrainYield.html")
    public Object listGrainYield(String pagination,
                                 String type) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        GrainYield grainYield = new GrainYield();
        grainYield.setType(type);
        PageData pageData = getPageData(grainYieldService.queryPage(pageParameter, grainYield));
        return R.ok(pageData);
    }

    @RequestMapping("/addGrainYield.html")
    public ModelAndView addGrainYield() {
        ModelAndView mv = new ModelAndView("/admin/AgriculturalBase/formGrainYield");
        return mv;
    }

    @RequestMapping("/addGrainYieldDo.html")
    public Object addGrainYieldDo(GrainYield grainYield) {
        if (StringUtils.isEmpty(grainYield.getId())) {
            grainYield.setId(UuidUtil.get32UUID());
            grainYield.setCreatetime(new Date());
            grainYieldService.insert(grainYield);
            return R.ok("新增成功");
        } else {
            grainYieldService.updateById(grainYield);
            return R.ok("修改成功");
        }
    }

    //删除
    @RequestMapping("/deleteGrainYieldDo.html")
    public Object deleteGrainYieldDo(@RequestParam("keyValue") String[] roleIds) {
        grainYieldService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
}
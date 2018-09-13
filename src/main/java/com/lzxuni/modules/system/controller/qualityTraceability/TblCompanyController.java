package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;


import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.Company;
import com.lzxuni.modules.system.entity.TblCompany;
import com.lzxuni.modules.system.service.TblCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * TblCompanyController
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-22
 * @description 
 **/
@RestController
@RequestMapping("/admin/ht/tblCompany")
public class TblCompanyController extends BaseController {

    @Autowired
    private TblCompanyService tblCompanyService;

    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/tblcompany/index");
        return mv;
    }
    // 列表c
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String queryJson) throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        TblCompany demo = JSON.parseObject(queryJson, TblCompany.class);
        if (demo == null) {
            demo = new TblCompany();
        }
        PageData pageData = getPageData(tblCompanyService.queryPage(pageParameter, demo));
        return R.ok(pageData);
    }
    // 新增,修改
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception{
        ModelAndView mv = new ModelAndView("/ht/tblcompany/Form");
        return mv;
    }
    // 新增,修改 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(TblCompany demo) throws Exception {

        if(StringUtils.isEmpty(demo.getId())){
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            tblCompanyService.insert(demo);
            return R.ok("新增成功");
        }else{
            tblCompanyService.updateById(demo);
            return R.ok("修改成功");
        }
    }
    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue")String[] roleIds){
        tblCompanyService.deleteBatchIds(Arrays.asList(roleIds));
        return  R.ok("删除成功");
    }
    // 根据parentId查找
    @RequestMapping("/GetTree.html")
    public Object queryListByParentId(String parentId) throws Exception {
        System.out.println("12312312312312312344444");
        List<TblCompany> tblcompanyList = tblCompanyService.queryList(new TblCompany());
        //System.out.println(R.ok(tblcompanyList));
       return R.ok(tblcompanyList);
        //return tblcompanyList;
    }
}

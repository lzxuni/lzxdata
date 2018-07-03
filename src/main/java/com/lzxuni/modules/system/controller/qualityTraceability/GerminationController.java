package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileEntityService;
import com.lzxuni.modules.system.entity.zlzs.Germination;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.service.GerminationService;
import com.lzxuni.modules.system.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;

/**
 * GerminationController
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-07-03
 * @description 
 **/
@RestController
@RequestMapping("/admin/ht/germination")
public class GerminationController extends BaseController {

    @Autowired
    private GerminationService germinationService;


    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/germination/index");
        return mv;
    }

    // 列表
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String cname) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Germination demo = JSON.parseObject(cname, Germination.class);
        if (demo == null) {
            demo = new Germination();
        }
        //Photo demo = new Photo();
       // demo.setCommodityid(cname);
        PageData pageData = getPageData(germinationService.queryPage(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,修改
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/germination/Form");
        return mv;
    }


    // 新增,修改 处理  qszqtp
    @RequestMapping("/insert_o.html")
    public Object insertDo(Germination demo) throws Exception {

        if(StringUtils.isEmpty(demo.getId())){
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            germinationService.insert(demo);
            return R.ok("新增成功");
        }else{
            germinationService.updateById(demo);
            return R.ok("修改成功");
        }
    }



    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        germinationService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


}



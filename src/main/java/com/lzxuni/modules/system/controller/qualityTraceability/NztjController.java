package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileEntityService;
import com.lzxuni.modules.system.entity.zjwd.Nztj;
import com.lzxuni.modules.system.entity.zjwd.Zjwd;
import com.lzxuni.modules.system.service.zjwd.NztjService;
import com.lzxuni.modules.system.service.zjwd.ZjwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;

/**

 *@描述 农资推荐

 *@参数

 *@返回值

 *@创建人  gyl

 *@创建时间  2018/8/10

 *@修改人和其它信息

 */
@RestController
@RequestMapping("/admin/ht/nztj")
public class NztjController extends BaseController {

    @Autowired
    private NztjService nztjService;
    @Autowired
    private FileEntityService fileEntityService;

    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/nztj/index");
        return mv;
    }

    // 列表
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String cname) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);

        Nztj demo = new Nztj();
        //demo.setCommodityid(cname);
        //PageData pageData = getPageData(photoService.queryPage(pageParameter, demo));
        PageData pageData = getPageData(nztjService.queryPage(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,修改
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/nztj/Form");
        return mv;
    }


    // 新增,修改 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(Nztj demo,String tts) throws Exception {

        if(StringUtils.isEmpty(demo.getId())){
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            nztjService.insert(demo);
            return R.ok("新增成功");
        }else{
            nztjService.updateById(demo);
            return R.ok("修改成功");
        }
    }



    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        nztjService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


}



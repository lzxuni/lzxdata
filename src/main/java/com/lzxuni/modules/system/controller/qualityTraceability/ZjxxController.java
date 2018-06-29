package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileBeanService;
import com.lzxuni.modules.system.entity.Commodity;
import com.lzxuni.modules.system.entity.zjwd.Zjxx;
import com.lzxuni.modules.system.entity.zjwd.ZjxxCustom;

import com.lzxuni.modules.system.service.zjwd.ZjxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * MachiningController
 *
 * @author gyl
 * @version 1.0
 * @createTime 2018-06-28
 * @description 
 **/
@RestController
@RequestMapping("/admin/ht/zjxx")
public class ZjxxController extends BaseController {

    @Autowired
    private ZjxxService zjxxService;
    @Autowired
    private FileBeanService fileBeanService;

    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/zjxx/index");
        return mv;
    }

    // 列表
    @RequestMapping("/index_o.html")
    public Object index_o(String pagination,
                          String cname) throws Exception {
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);

        ZjxxCustom demo = new ZjxxCustom();
        //demo.setCommodityid(cname);
        //PageData pageData = getPageData(photoService.queryPage(pageParameter, demo));
        PageData pageData = getPageData(zjxxService.queryListPhtotAndQszqtp(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/zjxx/Form");
        return mv;
    }

    // 修改
    @RequestMapping("/update_v.html")
    public ModelAndView update() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/zjxx/Form1");
        return mv;
    }

    // 新增, 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(ZjxxCustom zjxxCustom) throws Exception {
        System.out.println(zjxxCustom.toString());
        Zjxx demo = new Zjxx();
        demo.setId(UuidUtil.get32UUID());
        demo.setCreatetime(new Date());
        System.out.println("--------" + zjxxCustom.getZjtp());
        fileBeanService.insertFileBean(zjxxCustom.getZjtp(), demo.getId(), "专家头像", "zjtp");
        demo.setZjname(zjxxCustom.getZjname());
        demo.setZjschool(zjxxCustom.getZjschool());
        demo.setZjintroduction(zjxxCustom.getZjintroduction());
        demo.setPlnumber(zjxxCustom.getPlnumber());
        demo.setDznumber(zjxxCustom.getDznumber());

        zjxxService.insert(demo);
        return R.ok("新增成功");

    }

    // 修改 处理
    @RequestMapping("/update_o.html")
    public Object updateDo(ZjxxCustom zjxxCustom) throws Exception {
        System.out.println(zjxxCustom.toString());
        System.out.println("zjxxCustom.getQszqtpupdate()------"+zjxxCustom.getZjtpupdate());
        if (zjxxCustom.getZjtpupdate() != null ) {
            fileBeanService.delFileBean(zjxxCustom.getId());
            fileBeanService.insertFileBean(zjxxCustom.getZjtpupdate(), zjxxCustom.getId(), "专家头像", "zjtp");

        }
        Zjxx demo = new Zjxx();
        demo.setId(zjxxCustom.getId());
        demo.setCreatetime(zjxxCustom.getCreatetime());
        demo.setZjname(zjxxCustom.getZjname());
        demo.setZjschool(zjxxCustom.getZjschool());
        demo.setZjintroduction(zjxxCustom.getZjintroduction());
        demo.setPlnumber(zjxxCustom.getPlnumber());
        demo.setDznumber(zjxxCustom.getDznumber());
        zjxxService.updateById(demo);
        return R.ok("修改成功");
    }

    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        zjxxService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }

    // 商品列表
    @RequestMapping("/GetList.html")
    public Object queryListByParentId() throws Exception {
        List<Zjxx> zjxxList = zjxxService.queryList(new Zjxx());
        return R.ok(zjxxList);

    }
}



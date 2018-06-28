package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileBeanService;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.entity.zlzs.PhotoCustom;
import com.lzxuni.modules.system.service.PhotoService;
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
@RequestMapping("/admin/ht/photo")
public class PhotoController extends BaseController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private FileBeanService fileBeanService;

    // 列表
    @RequestMapping("/index_v.html")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/ht/photo/index");
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
        //Photo demo = new Photo();
        PhotoCustom demo = new PhotoCustom();
        demo.setCommodityid(cname);
        //PageData pageData = getPageData(photoService.queryPage(pageParameter, demo));
        PageData pageData = getPageData(photoService.queryListPhtotAndQszqtp(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/photo/Form");
        return mv;
    }

    // 修改
    @RequestMapping("/update_v.html")
    public ModelAndView update() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/photo/Form1");
        return mv;
    }

    // 新增, 处理
    @RequestMapping("/insert_o.html")
    public Object insertDo(PhotoCustom photoCustom) throws Exception {
        System.out.println(photoCustom.toString());
//        if (StringUtils.isEmpty(photoCustom.getId())) {
        Photo demo = new Photo();
        demo.setId(UuidUtil.get32UUID());
        demo.setCreatetime(new Date());
        System.out.println("--------" + photoCustom.getQszqtp());
        fileBeanService.insertFileBean(photoCustom.getQszqtp(), demo.getId(), "全生长期图片", "qszqtp");
        demo.setCommodityid(photoCustom.getCommodityid());
        demo.setPremarks(photoCustom.getPremarks());
        demo.setPtime(photoCustom.getPtime());
        demo.setPtitle(photoCustom.getPtitle());
        photoService.insert(demo);
        return R.ok("新增成功");
//        } else {
//            fileBeanService.delFileBean(photoCustom.getId());
//            fileBeanService.insertFileBean(photoCustom.getQszqtp(),photoCustom.getId(),"全生长期图片","qszqtp");
//            photoService.updateById(photoCustom);
//            return R.ok("修改成功");
//        }
    }

    // 修改 处理
    @RequestMapping("/update_o.html")
    public Object updateDo(PhotoCustom photoCustom) throws Exception {
        System.out.println(photoCustom.toString());
        System.out.println("photoCustom.getQszqtpupdate()------"+photoCustom.getQszqtpupdate());
        if (photoCustom.getQszqtpupdate() != null ) {
            fileBeanService.delFileBean(photoCustom.getId());
            fileBeanService.insertFileBean(photoCustom.getQszqtpupdate(), photoCustom.getId(), "全生长期图片", "qszqtp");

        }
        Photo demo = new Photo();
        demo.setId(photoCustom.getId());
        demo.setCreatetime(photoCustom.getCreatetime());
        demo.setCommodityid(photoCustom.getCommodityid());
        demo.setPremarks(photoCustom.getPremarks());
        demo.setPtime(photoCustom.getPtime());
        demo.setPtitle(photoCustom.getPtitle());
        photoService.updateById(demo);
        return R.ok("修改成功");
    }

    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        photoService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


}



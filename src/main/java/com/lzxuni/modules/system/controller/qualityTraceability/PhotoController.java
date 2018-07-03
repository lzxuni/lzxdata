package com.lzxuni.modules.system.controller.qualityTraceability;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileBeanService;
import com.lzxuni.modules.common.service.FileEntityService;
import com.lzxuni.modules.system.entity.zlzs.Photo;
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
    private FileEntityService fileEntityService;

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
        Photo demo = new Photo();
        demo.setCommodityid(cname);
        //PageData pageData = getPageData(photoService.queryPage(pageParameter, demo));
        PageData pageData = getPageData(photoService.queryPage(pageParameter, demo));
        return R.ok(pageData);
    }

    // 新增,修改
    @RequestMapping("/insert_v.html")
    public ModelAndView insert() throws Exception {
        ModelAndView mv = new ModelAndView("/ht/photo/Form");
        return mv;
    }


    // 新增,修改 处理  qszqtp
    @RequestMapping("/insert_o.html")
    public Object insertDo(Photo demo,String tts) throws Exception {
        String ids=demo.getId();
        if(ids.length()>32){
            ids=ids.split(",")[0];
        }else{
            ids=null;
        }
        demo.setId(ids);

        if(StringUtils.isEmpty(ids)){
            demo.setId(UuidUtil.get32UUID());
            demo.setCreatetime(new Date());
            fileEntityService.insert(tts,demo.getId(),"全生长期图片","qszqtp",demo.getPtitle());
            photoService.insert(demo);
            return R.ok("新增成功");
        }else{
            fileEntityService.deleteByYwId(demo.getId());
            fileEntityService.insert(tts,demo.getId(),"全生长期图片","qszqtp",demo.getPtitle());
            photoService.updateById(demo);
            return R.ok("修改成功");
        }
    }



    //删除
    @RequestMapping("/delete_o.html")
    public Object delete(@RequestParam("keyValue") String[] roleIds) {
        photoService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


}



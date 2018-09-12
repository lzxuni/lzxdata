package com.lzxuni.modules.system.controller.realTimeVideo;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.FileEntity;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.service.FileEntityService;
import com.lzxuni.modules.system.entity.realTimeVideo.RealTimeVideo;
import com.lzxuni.modules.system.service.realTimeVideo.RealTImeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/realtimevideo")
public class RealTimeVideoController extends BaseController{
    @Autowired
    private RealTImeVideoService realTImeVideoService;
    @Autowired
    private FileEntityService fileEntityService;

    @RequestMapping("/realtimevideo.html")
    public ModelAndView realtimevideo(){
        ModelAndView mv = new ModelAndView("/admin/RealTImeVideo/listVideo");
        return mv;
    }
    @RequestMapping("/listVideo.html")
    public ModelAndView listphoto(){
        ModelAndView mv  = new ModelAndView("/admin/RealTImeVideo/listPhoto");
        return mv;
    }
    @RequestMapping("/listVideoDo.html")
    public Object listphotoDo(String keyword,String pagination,String queryJson){
        PageParameter pageParameter = JSON.parseObject(pagination,PageParameter.class);
        RealTimeVideo realTimeVideo = JSON.parseObject(queryJson,RealTimeVideo.class);
        PageData pageData = getPageData(realTImeVideoService.queryPage(pageParameter, realTimeVideo));
        return R.ok(pageData);
    }
    @RequestMapping("/addVideo.html")
    public ModelAndView addVideo(){
        ModelAndView mv = new ModelAndView("/admin/RealTImeVideo/addVideo");
        return mv;
    }
    @RequestMapping("/addVideoDo.html")
    public Object addphoto(RealTimeVideo realTimeVideo,String photoid) throws Exception {
        if (StringUtils.isEmpty(realTimeVideo.getId())) {
            realTimeVideo.setId(UuidUtil.get32UUID());
            realTimeVideo.setPosition("哈尔滨");
            realTimeVideo.setPhotoid(UuidUtil.get32UUID());
            fileEntityService.insert(photoid,realTimeVideo.getPhotoid(),"实时视频背景","ssspbjtp","实时视频");
            realTImeVideoService.insert(realTimeVideo);
            return R.ok("新增成功");
        } else {
            String id= realTimeVideo.getId();
            RealTimeVideo realTimeVideo1=realTImeVideoService.findByPhotoId(id);
            realTimeVideo.setPhotoid(UuidUtil.get32UUID());
            fileEntityService.deleteByYwId(realTimeVideo1.getPhotoid());
            fileEntityService.insert(photoid,realTimeVideo.getPhotoid(),"实时视频背景","ssspbjtp","实时视频");
            realTImeVideoService.updateById(realTimeVideo);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delVideo.html")
    public Object delVideo(@RequestParam("keyValue")String[] roleIds){
        realTImeVideoService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }

}

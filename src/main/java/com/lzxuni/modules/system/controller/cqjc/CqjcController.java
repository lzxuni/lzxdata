package com.lzxuni.modules.system.controller.cqjc;

import com.alibaba.fastjson.JSON;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.FileEntity;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;

import com.lzxuni.modules.common.service.FileBeanService;
import com.lzxuni.modules.common.service.FileEntityService;
import com.lzxuni.modules.system.entity.cqjc.Cqjc;
import com.lzxuni.modules.system.entity.zlzs.Photo;
import com.lzxuni.modules.system.service.cqjc.CqjcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Arrays;

@RestController
@RequestMapping("/cqjc")
public class CqjcController extends BaseController{
    @Autowired
    private CqjcService cqjcService;
    @Autowired
    private FileEntityService fileEntityService;
    @RequestMapping("/list.html")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("admin/Cqjc/list");
        return mv;
    }
    @RequestMapping("/listDo")
    public Object listDo(String keyword,String pagination,
                         String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Cqjc cqjc =  JSON.parseObject(queryJson, Cqjc.class);
        if(cqjc == null){
            cqjc = new Cqjc();
            cqjc.setCollection(keyword);
            cqjc.setDensity(keyword);
            cqjc.setInsect(keyword);
            cqjc.setInsectNumber(keyword);
            cqjc.setoBservationTime(keyword);
            cqjc.setoBservatory(keyword);
            cqjc.setPhoto(keyword);
        }
        PageData pageData = getPageData(cqjcService.queryPage(pageParameter, cqjc));
        return R.ok(pageData);
    }
    @RequestMapping("/add.html")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView("admin/Cqjc/add");
        return mv;
    }
    @RequestMapping("/addDo")
    public Object addDo( Cqjc cqjc,String photo)throws Exception {
        if(StringUtils.isEmpty(cqjc.getId())){
            cqjc.setId(UuidUtil.get32UUID());
            cqjc.setPosition("哈尔滨");
            cqjc.setPhoto( UuidUtil.get32UUID());
            fileEntityService.insert(photo, cqjc.getPhoto(), "虫情检测", "cqjc","虫情检测");

            cqjcService.insert(cqjc);
            return R.ok("添加成功");
        }else{
            if(cqjc.getPhoto().length()<33){
                System.out.println("1111111111111111"+cqjc.getPhoto());
                cqjcService.updateById(cqjc);
            }else{
                System.out.println("222222222222222222");
              Cqjc cqjc1 =  cqjcService.selectById( cqjc.getId());
                fileEntityService.deleteByYwId(cqjc1.getPhoto());
                System.out.println("@@@@@@@@@@@@@@@"+cqjc1.getPhoto());
                fileEntityService.insert(photo, cqjc1.getPhoto(), "虫情检测", "cqjc","虫情检测");
                cqjc.setPhoto(cqjc1.getPhoto());
                cqjcService.updateById(cqjc);
            }
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/del")
    public Object del(@RequestParam("keyValue")String[] roleIds) throws SQLException {
        for (int i = 0; i <roleIds.length ; i++) {
            Cqjc cqjc = new Cqjc();
            System.out.println("@@@@@@"+roleIds[i]);
            if(!roleIds[i].equals("")){
                System.out.println("1234");
            cqjc =  cqjcService.selectById( roleIds[i]);
                fileEntityService.deleteByYwId(cqjc.getPhoto());
            }
        }


        cqjcService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }


    @RequestMapping("/chakan.html")
    public ModelAndView chakan(String ywId) throws Exception {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setYwId(ywId);
        FileEntity fileEntity1 =fileEntityService.queryByYwId(fileEntity);
        System.out.println("##########"+fileEntity1.getUrlPath());
        String url = fileEntity1.getUrlPath();
        ModelAndView mv = new ModelAndView("admin/Cqjc/chakan");
        mv.addObject("url",url);
        return mv;
    }
}

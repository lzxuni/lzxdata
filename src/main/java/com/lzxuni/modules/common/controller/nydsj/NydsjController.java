package com.lzxuni.modules.common.controller.nydsj;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzxuni.common.utils.R;
import com.lzxuni.common.utils.StringUtils;
import com.lzxuni.common.utils.UuidUtil;
import com.lzxuni.modules.common.controller.BaseController;
import com.lzxuni.modules.common.entity.PageData;
import com.lzxuni.modules.common.entity.PageParameter;
import com.lzxuni.modules.common.entity.nydsj.*;
import com.lzxuni.modules.common.service.nydsj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/nydsj")
public class NydsjController extends BaseController{
    @Autowired
    private LsjgService lsjgService;
    @Autowired
    private SdclService sdclService;
    @Autowired
    private TryjzService tryjzService;
    @Autowired
    private TrphzService trphzService;
    @Autowired
    private BjxxService bjxxService;
    @Autowired
    private ZzmjService zzmjService;
    @Autowired
    private HfService hfService;
    @Autowired
    private YxjService yxjService;
    @Autowired
    private YxlService yxlService;
    @Autowired
    private ZhsjService zhsjService;

    @RequestMapping("/lsjg.html")
    public ModelAndView lsjg(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Lsjg/list");
        return mv;
    }
    @RequestMapping("/lsjg_v")
    public Object lsjg_v(HttpServletRequest request,String keyword,String pagination,
                         String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Lsjg lsjg = JSON.parseObject(queryJson, Lsjg.class);
        if (lsjg == null) {
            lsjg = new Lsjg();
            lsjg.setCategory(keyword);
            lsjg.setPrice(keyword);
            lsjg.setYears(keyword);
        }
        PageData pageData = getPageData(lsjgService.queryPage(pageParameter, lsjg));

        return R.ok(pageData);
    }
    @RequestMapping("/addlsjg.html")
    public ModelAndView addlsjg(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Lsjg/add");
        return mv;
    }
    @RequestMapping("/addlsjgDo")
    public Object addlsjgDo(Lsjg lsjg){
        if(StringUtils.isEmpty(lsjg.getId())){
        lsjg.setId(UuidUtil.get32UUID());
        lsjg.setPosition("哈尔滨");
        lsjgService.insert(lsjg);
        return R.ok("添加成功");
        }else{
            lsjgService.updateById(lsjg);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/dellsjg")
    public Object dellsjg(@RequestParam("keyValue")String[] roleIds){
        lsjgService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    //水稻产量模块
    @RequestMapping("sdcl.html")
    public ModelAndView sdcl(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Sdcl/list");
        return mv;
    }
    @RequestMapping("sdcl_v")
    public Object sdcl_v(String keyword,String pagination,
                         String queryJson){
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Sdcl sdcl = JSON.parseObject(queryJson, Sdcl.class);
        if (sdcl == null) {
            sdcl = new Sdcl();
            sdcl.setYield(keyword);
            sdcl.setVillage(keyword);
            sdcl.setYears(keyword);
        }
        PageData pageData = getPageData(sdclService.queryPage(pageParameter, sdcl));

        return R.ok(pageData);
    }
    @RequestMapping("/addsdcl.html")
    public ModelAndView addsdcl(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Sdcl/add");
        return mv;
    }

    @RequestMapping("/addsdclDo")
    public Object addsdclDo(Sdcl sdcl){
        if(StringUtils.isEmpty(sdcl.getId())){
            sdcl.setId(UuidUtil.get32UUID());
            sdcl.setPosition("哈尔滨");
            sdclService.insert(sdcl);
            return R.ok("添加成功");
        }else{
            sdclService.updateById(sdcl);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delsdcl")
    public Object delsdcl(@RequestParam("keyValue")String[] roleIds){
        sdclService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    //土壤有机质模块
    @RequestMapping("tryjz.html")
    public ModelAndView tryjz(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Tryjz/list");
        return mv;
    }
    @RequestMapping("tryjz_v")
    public Object tryjz_v(String keyword,String pagination,
                          String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Tryjz tryjz = JSON.parseObject(queryJson, Tryjz.class);
        if (tryjz == null) {
            tryjz = new Tryjz();
            tryjz.setRegion(keyword);
            tryjz.setRanges(keyword);
            tryjz.setOrganic(keyword);
        }
        PageData pageData = getPageData(tryjzService.queryPage(pageParameter, tryjz));

        return R.ok(pageData);
    }
    @RequestMapping("/addtryjz.html")
    public ModelAndView addtryjz(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Tryjz/add");
        return mv;
    }

    @RequestMapping("/addtryjzDo")
    public Object addtryjzDo(Tryjz tryjz){
        if(StringUtils.isEmpty(tryjz.getId())){
            tryjz.setId(UuidUtil.get32UUID());
            tryjz.setPosition("哈尔滨");
            tryjzService.insert(tryjz);
            return R.ok("添加成功");
        }else{
            tryjzService.updateById(tryjz);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/deltryjz")
    public Object deltryjz(@RequestParam("keyValue")String[] roleIds){
        tryjzService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    //土壤PH值模块
    @RequestMapping("trphz.html")
    public ModelAndView trphz(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Trphz/list");
        return mv;
    }
    @RequestMapping("trphz_v")
    public Object trphz_v(String keyword,String pagination,
                          String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        System.out.println("##############"+pagination);
        Trphz trphz = JSON.parseObject(queryJson, Trphz.class);
        if (trphz == null) {
            trphz = new Trphz();
            trphz.setPh(keyword);
            trphz.setRegion(keyword);
        }
        PageData pageData = getPageData(trphzService.queryPage(pageParameter, trphz));

        return R.ok(pageData);

    }
    @RequestMapping("/addtrphz.html")
    public ModelAndView addtrphz(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Trphz/add");
        return mv;
    }

    @RequestMapping("/addtrphzDo")
    public Object addtrphzDo(Trphz trphz){
        if(StringUtils.isEmpty(trphz.getId())){
            trphz.setId(UuidUtil.get32UUID());
            trphz.setPosition("哈尔滨");
            trphzService.insert(trphz);
            return R.ok("添加成功");
        }else{
            trphzService.updateById(trphz);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/deltrphz")
    public Object deltrphz(@RequestParam("keyValue")String[] roleIds){
        trphzService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    //报警信息模块
    @RequestMapping("bjxx.html")
    public ModelAndView bjxx(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Bjxx/list");
        return mv;
    }
    @RequestMapping("bjxx_v")
    public Object bjxx_v(String keyword,String pagination,
                         String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Bjxx bjxx = JSON.parseObject(queryJson, Bjxx.class);
        if (bjxx == null) {
            bjxx = new Bjxx();
            bjxx.setStandard(keyword);
            bjxx.setSituationValue(keyword);
            bjxx.setSituation(keyword);
            bjxx.setRegion(keyword);
            bjxx.setCreateDate(keyword);
        }
        PageData pageData = getPageData(bjxxService.queryPage(pageParameter, bjxx));

        return R.ok(pageData);
    }
    @RequestMapping("/addbjxx.html")
    public ModelAndView addbjxx(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Bjxx/add");
        return mv;
    }

    @RequestMapping("/addbjxxDo")
    public Object addbjxxDo(Bjxx bjxx){
        if(StringUtils.isEmpty(bjxx.getId())){
            bjxx.setId(UuidUtil.get32UUID());
            bjxx.setPosition("哈尔滨");
            bjxxService.insert(bjxx);
            return R.ok("添加成功");
        }else{
            bjxxService.updateById(bjxx);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delbjxx")
    public Object delbjxx(@RequestParam("keyValue")String[] roleIds){
        bjxxService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }

    /**
     *
     * @return
     * 种植面积模块
     */

    @RequestMapping("zzmj.html")
    public ModelAndView zzmj(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Zzmj/list");
        return mv;
    }
    @RequestMapping("zzmj_v")
    public Object zzmj_v(String keyword,String pagination,
                         String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Zzmj zzmj  = JSON.parseObject(queryJson, Zzmj.class);
        if (zzmj == null) {
            zzmj = new Zzmj();
            zzmj.setCategory(keyword);
            zzmj.setArea(keyword);
        }
        PageData pageData = getPageData(zzmjService.queryPage(pageParameter, zzmj));

        return R.ok(pageData);
    }
    @RequestMapping("/addzzmj.html")
    public ModelAndView addzzmj(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Zzmj/add");
        return mv;
    }

    @RequestMapping("/addzzmjDo")
    public Object addzzmjDo(Zzmj zzmj){
        if(StringUtils.isEmpty(zzmj.getId())){
            zzmj.setId(UuidUtil.get32UUID());
            zzmj.setPosition("哈尔滨");
            zzmjService.insert(zzmj);
            return R.ok("添加成功");
        }else{
            zzmjService.updateById(zzmj);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delzzmj")
    public Object delzzmj(@RequestParam("keyValue")String[] roleIds){
        zzmjService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    /**
     * 化肥模块
     */

    @RequestMapping("hf.html")
    public ModelAndView hf(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Hf/list");
        return mv;
    }
    @RequestMapping("hf_v")
    public Object hf_v(String keyword,String pagination,
                       String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Hf hf = JSON.parseObject(queryJson, Hf.class);
        if (hf == null) {
            hf = new Hf();
            hf.setCategory(keyword);
            hf.setWeight(keyword);
        }
        PageData pageData = getPageData(hfService.queryPage(pageParameter, hf));

        return R.ok(pageData);
    }
    @RequestMapping("/addhf.html")
    public ModelAndView addhf(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Hf/add");
        return mv;
    }

    @RequestMapping("/addhfDo")
    public Object addhfDo(Hf hf){
        if(StringUtils.isEmpty(hf.getId())){
            hf.setId(UuidUtil.get32UUID());
            hf.setPosition("哈尔滨");
            hfService.insert(hf);
            return R.ok("添加成功");
        }else{
            hfService.updateById(hf);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delhf")
    public Object delhf(@RequestParam("keyValue")String[] roleIds){
        hfService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    /**
     * 有效钾模块
     */
    @RequestMapping("yxj.html")
    public ModelAndView yxj(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Yxj/list");
        return mv;
    }
    @RequestMapping("yxj_v")
    public Object yxj_v(String keyword,String pagination,
                        String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Yxj yxj = JSON.parseObject(queryJson, Yxj.class);
        if (yxj == null) {
            yxj = new Yxj();
            yxj.setPotassium(keyword);
            yxj.setRegion(keyword);
        }
        PageData pageData = getPageData(yxjService.queryPage(pageParameter, yxj));
        return R.ok(pageData);
    }
    @RequestMapping("/addyxj.html")
    public ModelAndView addyxj(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Yxj/add");
        return mv;
    }

    @RequestMapping("/addyxjDo")
    public Object addyxjDo(Yxj yxj){
        if(StringUtils.isEmpty(yxj.getId())){
            yxj.setId(UuidUtil.get32UUID());
            yxj.setPosition("哈尔滨");
            yxjService.insert(yxj);
            return R.ok("添加成功");
        }else{
            yxjService.updateById(yxj);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delyxj")
    public Object delyxj(@RequestParam("keyValue")String[] roleIds){
        yxjService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    /**
     * 有效磷模块
     */
    @RequestMapping("yxl.html")
    public ModelAndView yxl(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Yxl/list");
        return mv;
    }
    @RequestMapping("yxl_v")
    public Object yxl_v(String keyword,String pagination,
                        String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Yxl yxl = JSON.parseObject(queryJson, Yxl.class);
        if (yxl == null) {
            yxl = new Yxl();
            yxl.setPhosphorus(keyword);
            yxl.setRegion(keyword);
        }
        PageData pageData = getPageData(yxlService.queryPage(pageParameter, yxl));

        return R.ok(pageData);
    }
    @RequestMapping("/addyxl.html")
    public ModelAndView addyxl(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Yxl/add");
        return mv;
    }

    @RequestMapping("/addyxlDo")
    public Object addyxlDo(Yxl yxl){
        if(StringUtils.isEmpty(yxl.getId())){
            yxl.setId(UuidUtil.get32UUID());
            yxl.setPosition("哈尔滨");
            yxlService.insert(yxl);
            return R.ok("添加成功");
        }else{
            yxlService.updateById(yxl);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delyxl")
    public Object delyxl(@RequestParam("keyValue")String[] roleIds){
        yxlService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
    /**
     * 其他数据
     */
    @RequestMapping("zhsj.html")
    public ModelAndView zhsj(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Zhsj/list");
        return mv;
    }
    @RequestMapping("zhsj_v")
    public Object zhsj_v(String keyword,String pagination,
                         String queryJson)throws Exception{
        PageParameter pageParameter = JSON.parseObject(pagination, PageParameter.class);
        Zhsj zhsj = JSON.parseObject(queryJson, Zhsj.class);
        if (zhsj == null) {
            zhsj = new Zhsj();
            zhsj.setHumidity(keyword);
            zhsj.setQuality(keyword);
            zhsj.setRainfall(keyword);
            zhsj.setStrength(keyword);
            zhsj.setTemperature(keyword);
        }
        PageData pageData = getPageData(zhsjService.queryPage(pageParameter, zhsj));

        return R.ok(pageData);
    }
    @RequestMapping("/addzhsj.html")
    public ModelAndView addzhsj(){
        ModelAndView mv = new ModelAndView("admin/Nydsj/Zhsj/add");
        return mv;
    }

    @RequestMapping("/addzhsjDo")
    public Object addzhsjDo(Zhsj zhsj){
        if(StringUtils.isEmpty(zhsj.getId())){
            zhsj.setId(UuidUtil.get32UUID());
            zhsj.setPosition("哈尔滨");
            zhsjService.insert(zhsj);
            return R.ok("添加成功");
        }else{
            zhsjService.updateById(zhsj);
            return R.ok("修改成功");
        }
    }
    @RequestMapping("/delzhsj")
    public Object delzhsj(@RequestParam("keyValue")String[] roleIds){
        zhsjService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok("删除成功");
    }
}

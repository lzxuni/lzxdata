package com.lzxuni.modules.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年6月27日
 *
 * @version 1.0 <br>
 */
@TableName("tbl_zlzs_fertilizer")
public class Fertilizer implements Serializable {


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String id;    //
    private String flname;    //	肥料名称
    private String flunit;    //	肥料生产单位
    private String sftime;    //	施肥时间
    private String fltype;    //	肥料种类
    private String sfmethod;    //	施肥方法
    private String number;    //	用量
    private String people;    //	责任人
    private String commodityid;    //	商品ID


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public String getFlunit() {
        return flunit;
    }

    public void setFlunit(String flunit) {
        this.flunit = flunit;
    }

    public String getSftime() {
        return sftime;
    }

    public void setSftime(String sftime) {
        this.sftime = sftime;
    }

    public String getFltype() {
        return fltype;
    }

    public void setFltype(String fltype) {
        this.fltype = fltype;
    }

    public String getSfmethod() {
        return sfmethod;
    }

    public void setSfmethod(String sfmethod) {
        this.sfmethod = sfmethod;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }



}

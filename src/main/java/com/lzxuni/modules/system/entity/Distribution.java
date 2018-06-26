package com.lzxuni.modules.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年6月25日
 *
 * @version 1.0 <br>
 */
@TableName("tbl_zlzs_distribution")
public class Distribution implements Serializable {


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String id;    //
    private String ystime;    //	运输时间
    private String temperature;    //	贮存温度
    private String thecar;    //	车辆描述
    private String license;    //	车牌
    private String people;    //	负责人
    private String number;    //	运输数量
    private String commodityid;    //	商品ID
    private String ysaddress;    //	收货地址

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

    public String getYstime() {
        return ystime;
    }

    public void setYstime(String ystime) {
        this.ystime = ystime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getThecar() {
        return thecar;
    }

    public void setThecar(String thecar) {
        this.thecar = thecar;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getYsaddress() {
        return ysaddress;
    }

    public void setYsaddress(String ysaddress) {
        this.ysaddress = ysaddress;
    }
}

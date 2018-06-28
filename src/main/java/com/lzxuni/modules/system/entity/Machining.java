package com.lzxuni.modules.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年6月26日
 *
 * @version 1.0 <br>
 */
@TableName("tbl_zlzs_machining")
public class Machining implements Serializable {


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String jgtime;    //	加工时间
    private String jytime;    //	检验时间

    private String id;    //
    private String jgbatch;    //	加工批次
    private String machiningno;    //	加工量
    private String people;    //	负责人
    private String scbatch;    //	生产批次

    private String inspectxm;    //	检查项目
    private String inspectno;    //	检查数量
    private String inspectjg;    //	检查结果
    private String commodityid;    //	商品id

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

    public String getJgbatch() {
        return jgbatch;
    }

    public void setJgbatch(String jgbatch) {
        this.jgbatch = jgbatch;
    }



    public String getMachiningno() {
        return machiningno;
    }

    public void setMachiningno(String machiningno) {
        this.machiningno = machiningno;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getScbatch() {
        return scbatch;
    }

    public void setScbatch(String scbatch) {
        this.scbatch = scbatch;
    }

    public String getInspectxm() {
        return inspectxm;
    }

    public void setInspectxm(String inspectxm) {
        this.inspectxm = inspectxm;
    }

    public String getInspectno() {
        return inspectno;
    }

    public void setInspectno(String inspectno) {
        this.inspectno = inspectno;
    }

    public String getInspectjg() {
        return inspectjg;
    }

    public void setInspectjg(String inspectjg) {
        this.inspectjg = inspectjg;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getJgtime() {
        return jgtime;
    }

    public void setJgtime(String jgtime) {
        this.jgtime = jgtime;
    }

    public String getJytime() {
        return jytime;
    }

    public void setJytime(String jytime) {
        this.jytime = jytime;
    }
}

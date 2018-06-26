package com.lzxuni.modules.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年6月21日
 *
 * @version 1.0 <br>
 */
@TableName("tbl_zlzs_commodity")
public class Commodity implements Serializable {


    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    //标识是否超级管理员Y，是，N不是，超级管理员，保证角色用户不可以删除，系统点不坏，非超级管理员，不读取，但超级管理员修改资料可以查询
    private String id; //
    private String cname;   //商品名称
    private String cspecifications; //规格
    private String cprice;  //价格
    private String cbatchnumber;    //产品批号
    private String cperiod;     //保质期
    private String ccategory;   //认证类别
    private String enterpriseid;    //企业id


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCspecifications() {
        return cspecifications;
    }

    public void setCspecifications(String cspecifications) {
        this.cspecifications = cspecifications;
    }

    public String getCprice() {
        return cprice;
    }

    public void setCprice(String cprice) {
        this.cprice = cprice;
    }

    public String getCbatchnumber() {
        return cbatchnumber;
    }

    public void setCbatchnumber(String cbatchnumber) {
        this.cbatchnumber = cbatchnumber;
    }

    public String getCperiod() {
        return cperiod;
    }

    public void setCperiod(String cperiod) {
        this.cperiod = cperiod;
    }

    public String getCcategory() {
        return ccategory;
    }

    public void setCcategory(String ccategory) {
        this.ccategory = ccategory;
    }

    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

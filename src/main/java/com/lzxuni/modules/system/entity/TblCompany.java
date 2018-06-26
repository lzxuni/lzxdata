package com.lzxuni.modules.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * gyl
 * 2018-06-22 8:55
 *
 *
 */


@TableName("tbl_zlzs_company")
public class TblCompany implements Serializable {

    private	String	id	;	//
    private	String	coname	;	//	企业名称
    private	String	cobody	;	//	负责人
    private	String	cophone	;	//	联系电话
    private	String	coaddress	;	//	地址
    private	String	coposition	;	//	地块位置
    private	String	cointroduction	;	//	公司简介
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public String getCobody() {
        return cobody;
    }

    public void setCobody(String cobody) {
        this.cobody = cobody;
    }

    public String getCophone() {
        return cophone;
    }

    public void setCophone(String cophone) {
        this.cophone = cophone;
    }

    public String getCoaddress() {
        return coaddress;
    }

    public void setCoaddress(String coaddress) {
        this.coaddress = coaddress;
    }

    public String getCoposition() {
        return coposition;
    }

    public void setCoposition(String coposition) {
        this.coposition = coposition;
    }

    public String getCointroduction() {
        return cointroduction;
    }

    public void setCointroduction(String cointroduction) {
        this.cointroduction = cointroduction;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

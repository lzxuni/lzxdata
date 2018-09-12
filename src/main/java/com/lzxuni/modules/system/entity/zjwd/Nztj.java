package com.lzxuni.modules.system.entity.zjwd;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**

 *@描述 农资推荐

 *@参数

 *@返回值

 *@创建人  gyl

 *@创建时间  2018/8/10

 *@修改人和其它信息

 */
@TableName("tbl_zjwd_nztj")
public class Nztj implements Serializable {


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private	String	id	;	//
    private	String	dianming	;	//	商店名称
    private	String	nongziname	;	//	农资名称
    private	String	jianjie	;	//	农资简介
    private	String	dizhi	;	//	地址
    private	String	lianxiren	;	//	联系人
    private	String	dianhua	;	//	电话

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

    public String getDianming() {
        return dianming;
    }

    public void setDianming(String dianming) {
        this.dianming = dianming;
    }

    public String getNongziname() {
        return nongziname;
    }

    public void setNongziname(String nongziname) {
        this.nongziname = nongziname;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getLianxiren() {
        return lianxiren;
    }

    public void setLianxiren(String lianxiren) {
        this.lianxiren = lianxiren;
    }

    public String getDianhua() {
        return dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    @Override
    public String toString() {
        return "Nztj{" +
                "createtime=" + createtime +
                ", id='" + id + '\'' +
                ", dianming='" + dianming + '\'' +
                ", nongziname='" + nongziname + '\'' +
                ", jianjie='" + jianjie + '\'' +
                ", dizhi='" + dizhi + '\'' +
                ", lianxiren='" + lianxiren + '\'' +
                ", dianhua='" + dianhua + '\'' +
                '}';
    }
}

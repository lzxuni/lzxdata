package com.lzxuni.modules.system.entity.zjwd;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年6月28日
 *
 * @version 1.0 <br>
 */
@TableName("tbl_zjwd_zjxx")
public class Zjxx implements Serializable {


    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private	String	id	;	//
    private	String	zjname	;	//	专家姓名
    private	String	zjschool	;	//	任职单位
    private	String	zjintroduction	;	//	简介
    private	String	plnumber	;	//	评论数
    private	String	dznumber	;	//	点赞数

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

    public String getZjname() {
        return zjname;
    }

    public void setZjname(String zjname) {
        this.zjname = zjname;
    }

    public String getZjschool() {
        return zjschool;
    }

    public void setZjschool(String zjschool) {
        this.zjschool = zjschool;
    }

    public String getZjintroduction() {
        return zjintroduction;
    }

    public void setZjintroduction(String zjintroduction) {
        this.zjintroduction = zjintroduction;
    }

    public String getPlnumber() {
        return plnumber;
    }

    public void setPlnumber(String plnumber) {
        this.plnumber = plnumber;
    }

    public String getDznumber() {
        return dznumber;
    }

    public void setDznumber(String dznumber) {
        this.dznumber = dznumber;
    }

    @Override
    public String toString() {
        return "zjxx{" +
                "createtime=" + createtime +
                ", id='" + id + '\'' +
                ", zjname='" + zjname + '\'' +
                ", zjschool='" + zjschool + '\'' +
                ", zjintroduction='" + zjintroduction + '\'' +
                ", plnumber='" + plnumber + '\'' +
                ", dznumber='" + dznumber + '\'' +
                '}';
    }
}

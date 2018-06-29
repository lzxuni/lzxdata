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
@TableName("tbl_zjwd_zjwd")
public class Zjwd implements Serializable {


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String id;    //
    private String wttitle;    //	标题
    private String wtneirong;    //	问题内容
    private String zjid;    //	专家id
    private String zjanswer;    //	专家回答
    private String zhuiwen;    //	追问
    private String zhuida;    //	追答

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

    public String getWttitle() {
        return wttitle;
    }

    public void setWttitle(String wttitle) {
        this.wttitle = wttitle;
    }

    public String getWtneirong() {
        return wtneirong;
    }

    public void setWtneirong(String wtneirong) {
        this.wtneirong = wtneirong;
    }

    public String getZjid() {
        return zjid;
    }

    public void setZjid(String zjid) {
        this.zjid = zjid;
    }

    public String getZjanswer() {
        return zjanswer;
    }

    public void setZjanswer(String zjanswer) {
        this.zjanswer = zjanswer;
    }

    public String getZhuiwen() {
        return zhuiwen;
    }

    public void setZhuiwen(String zhuiwen) {
        this.zhuiwen = zhuiwen;
    }

    public String getZhuida() {
        return zhuida;
    }

    public void setZhuida(String zhuida) {
        this.zhuida = zhuida;
    }

    @Override
    public String toString() {
        return "Zjwd{" +
                "createtime=" + createtime +
                ", id='" + id + '\'' +
                ", wttitle='" + wttitle + '\'' +
                ", wtneirong='" + wtneirong + '\'' +
                ", zjid='" + zjid + '\'' +
                ", zjanswer='" + zjanswer + '\'' +
                ", zhuiwen='" + zhuiwen + '\'' +
                ", zhuida='" + zhuida + '\'' +
                '}';
    }
}

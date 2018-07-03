package com.lzxuni.modules.system.entity.zlzs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年7月03日
 *
 * @version 1.0 <br>
 */
@TableName("tbl_zlzs_germination")
public class Germination implements Serializable {


    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private	String	id	;	//
    private	String	xztime	;	//	选种日期
    private	String	yztime	;	//	育种日期
    private	String	gztime	;	//	耕种日期
    private	String	yhtime	;	//	养护日期
    private	String	sgtime	;	//	收割日期
    private String commodityid;    //	商品ID

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

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

    public String getXztime() {
        return xztime;
    }

    public void setXztime(String xztime) {
        this.xztime = xztime;
    }

    public String getYztime() {
        return yztime;
    }

    public void setYztime(String yztime) {
        this.yztime = yztime;
    }

    public String getGztime() {
        return gztime;
    }

    public void setGztime(String gztime) {
        this.gztime = gztime;
    }

    public String getYhtime() {
        return yhtime;
    }

    public void setYhtime(String yhtime) {
        this.yhtime = yhtime;
    }

    public String getSgtime() {
        return sgtime;
    }

    public void setSgtime(String sgtime) {
        this.sgtime = sgtime;
    }

    @Override
    public String toString() {
        return "Germination{" +
                "createtime=" + createtime +
                ", id='" + id + '\'' +
                ", xztime='" + xztime + '\'' +
                ", yztime='" + yztime + '\'' +
                ", gztime='" + gztime + '\'' +
                ", yhtime='" + yhtime + '\'' +
                ", sgtime='" + sgtime + '\'' +
                ", commodityid='" + commodityid + '\'' +
                '}';
    }
}

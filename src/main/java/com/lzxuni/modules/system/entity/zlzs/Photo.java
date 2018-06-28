package com.lzxuni.modules.system.entity.zlzs;

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
@TableName("tbl_zlzs_photo")
public class Photo implements Serializable {


    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private	String	id	;	//
    private	String	commodityid	;	//	商品id
    private	String	ptitle	;	//	标题
    private	String	premarks	;	//	备注
    private	String	ptime	;	//	时间


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

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPremarks() {
        return premarks;
    }

    public void setPremarks(String premarks) {
        this.premarks = premarks;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "createtime=" + createtime +
                ", id='" + id + '\'' +
                ", commodityid='" + commodityid + '\'' +
                ", ptitle='" + ptitle + '\'' +
                ", premarks='" + premarks + '\'' +
                ", ptime='" + ptime + '\'' +
                '}';
    }
}

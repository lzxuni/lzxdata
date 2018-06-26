package com.lzxuni.modules.system.controller;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("tbl_GrainYield")
public class GrainYield {
    private String id;
    private String type;
    private String value;
    private String years;
    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "GrainYield{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", years='" + years + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}

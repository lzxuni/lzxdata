package com.lzxuni.modules.system.entity.AgriculturalEncyclopedia;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("tbl_nybk_nybk")
public class AgriculturalEncyclopedia {
    private String id;
    private String content;
    private String type;
    private String title;
    private String contentsource;
    private Date createtime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentsource() {
        return contentsource;
    }

    public void setContentsource(String contentsource) {
        this.contentsource = contentsource;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

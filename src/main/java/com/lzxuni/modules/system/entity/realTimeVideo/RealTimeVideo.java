package com.lzxuni.modules.system.entity.realTimeVideo;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("tbl_sssp")
public class RealTimeVideo {
    private String id;
    private String position;//关联位置
    private String photoid;//图片id
    private String videoid;//视频id
    private String detailed;//详解
    private Date createdate;//创建时间

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "RealTimeVideo{" +
                "id='" + id + '\'' +
                ", photoid='" + photoid + '\'' +
                ", videoid='" + videoid + '\'' +
                ", detailed='" + detailed + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}

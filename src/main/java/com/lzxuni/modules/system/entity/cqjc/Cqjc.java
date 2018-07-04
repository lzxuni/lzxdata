package com.lzxuni.modules.system.entity.cqjc;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("tbl_cqjc")
public class Cqjc {
    private String id;
    private String position;//关联位置
    private String collection;//采集位置
    private String insect;//虫名
    private String insectNumber;//数量
    private String density;//密度
    private String oBservatory;//观测员
    private String oBservationTime;//观测时间
    private String photo;//照片

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getInsect() {
        return insect;
    }

    public void setInsect(String insect) {
        this.insect = insect;
    }



    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getInsectNumber() {
        return insectNumber;
    }

    public void setInsectNumber(String insectNumber) {
        this.insectNumber = insectNumber;
    }

    public String getoBservatory() {
        return oBservatory;
    }

    public void setoBservatory(String oBservatory) {
        this.oBservatory = oBservatory;
    }

    public String getoBservationTime() {
        return oBservationTime;
    }

    public void setoBservationTime(String oBservationTime) {
        this.oBservationTime = oBservationTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

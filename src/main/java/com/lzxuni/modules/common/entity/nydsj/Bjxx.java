package com.lzxuni.modules.common.entity.nydsj;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("tbl_nydsj_bjxx")
public class Bjxx {
    private String id;
    private String position;//关联位置
    private String createDate;//日期
    private String region;//地区
    private String situation;//情形
    private String situationValue;//情形数值
    private String standard;//标准数值

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getSituationValue() {
        return situationValue;
    }

    public void setSituationValue(String situationValue) {
        this.situationValue = situationValue;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}

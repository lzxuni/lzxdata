package com.lzxuni.modules.common.entity.nydsj;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("tbl_nydsj_trphz")
public class Trphz {
    private String id;
    private String position;//关联位置
    private String ph;//PH值
    private String region;//地区

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

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

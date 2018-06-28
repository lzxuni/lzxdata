package com.lzxuni.modules.common.entity.nydsj;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("tbl_nydsj_zhsj")
public class Zhsj {
    private String id;
    private String position;//关联位置
    private String strength;//光照强度
    private String temperature;//空气温度
    private String humidity;//土壤湿度
    private String rainfall;//降雨雨量
    private String quality;//空气质量

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

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}

package com.lzxuni.modules.system.entity.PrecisionFarming;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("tbl_jzny_precisionfarming")
public class PrecisionFarming {
    private String id;
    private String winddirection;
    private String windspeed;
    private String rainfall;
    private String airtemperature;
    private String airhumidity;
    private String soiltemperature;
    private String soilmoisture;
    private String lightintensity;
    private String co2concentration;
    private Date createtime;
    private String time;
    private String addressid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getAirtemperature() {
        return airtemperature;
    }

    public void setAirtemperature(String airtemperature) {
        this.airtemperature = airtemperature;
    }

    public String getAirhumidity() {
        return airhumidity;
    }

    public void setAirhumidity(String airhumidity) {
        this.airhumidity = airhumidity;
    }

    public String getSoiltemperature() {
        return soiltemperature;
    }

    public void setSoiltemperature(String soiltemperature) {
        this.soiltemperature = soiltemperature;
    }

    public String getSoilmoisture() {
        return soilmoisture;
    }

    public void setSoilmoisture(String soilmoisture) {
        this.soilmoisture = soilmoisture;
    }

    public String getLightintensity() {
        return lightintensity;
    }

    public void setLightintensity(String lightintensity) {
        this.lightintensity = lightintensity;
    }

    public String getCo2concentration() {
        return co2concentration;
    }

    public void setCo2concentration(String co2concentration) {
        this.co2concentration = co2concentration;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid;
    }

    @Override
    public String toString() {
        return "PrecisionFarming{" +
                "id='" + id + '\'' +
                ", winddirection='" + winddirection + '\'' +
                ", windspeed='" + windspeed + '\'' +
                ", rainfall='" + rainfall + '\'' +
                ", airtemperature='" + airtemperature + '\'' +
                ", airhumidity='" + airhumidity + '\'' +
                ", soiltemperature='" + soiltemperature + '\'' +
                ", soilmoisture='" + soilmoisture + '\'' +
                ", lightintensity='" + lightintensity + '\'' +
                ", co2concentration='" + co2concentration + '\'' +
                ", createtime=" + createtime +
                ", time='" + time + '\'' +
                ", addressid='" + addressid + '\'' +
                '}';
    }
}

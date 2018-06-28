package com.lzxuni.modules.common.entity.nydsj;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * zth
 */
@TableName("tbl_nydsj_lsjg")
public class Lsjg {
    private String id;
    private String position;//位置
    private String category;//品类
    private String price;//价格
    private String years;//年份

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}

package com.lzxuni.modules.common.entity.nydsj;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("tbl_nydsj_hf")
public class Hf {
    private String id;
    private String category;
    private String weight;
    private String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

package com.lzxuni.modules.system.entity.zlzs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年6月28日
 *
 * @version 1.0 <br>
 */

public class PhotoCustom extends Photo {
    private	String	qszqtp	;	//	图片
    private	String	qszqtpupdate	;	//	图片

    public String getQszqtp() {
        return qszqtp;
    }

    public void setQszqtp(String qszqtp) {
        this.qszqtp = qszqtp;
    }

    public String getQszqtpupdate() {
        return qszqtpupdate;
    }

    public void setQszqtpupdate(String qszqtpupdate) {
        this.qszqtpupdate = qszqtpupdate;
    }


}

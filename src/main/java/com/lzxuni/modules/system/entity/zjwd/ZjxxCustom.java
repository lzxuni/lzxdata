package com.lzxuni.modules.system.entity.zjwd;

import com.lzxuni.modules.system.entity.zlzs.Photo;

/**
 * <b>功能：</b> <br>
 * <b>作者：</b>gyl<br>
 * <b>日期：</b>2018年6月29日
 *
 * @version 1.0 <br>
 */

public class ZjxxCustom extends Zjxx {
    private	String	zjtp	;	//	图片
    private	String	zjtpupdate	;	//	图片

    public String getZjtp() {
        return zjtp;
    }

    public void setZjtp(String zjtp) {
        this.zjtp = zjtp;
    }

    public String getZjtpupdate() {
        return zjtpupdate;
    }

    public void setZjtpupdate(String zjtpupdate) {
        this.zjtpupdate = zjtpupdate;
    }
}

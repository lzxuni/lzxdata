package com.lzxuni.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统配置，读取静态资源目录位置
 * <b>功能：</b> <br>
 * <b>作者：</b>孙志强<br>
 * <b>日期：</b>2017年7月4日 下午1:59:00
 * @version 1.0 <br>
 */
@ConfigurationProperties(prefix = "lzxuni.attachment")
@Component
public class AttachmentConfig {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
package org.jcloud.jwechat.config;

import lombok.*;


/**
 * @Title WxConfig
 * @Description 微信配置类
 * @Author ZhangKai
 * @Date 2020/4/1 0001
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WxConfig {

    private String appid;
    private String secret;
    private String encodingaeskey;
    private String token;
    private boolean cipher;
    public WxConfig(String appid, String secret, String encodingaeskey, String token) {
        this.appid = appid;
        this.secret = secret;
        this.encodingaeskey = encodingaeskey;
        this.token = token;
    }
}

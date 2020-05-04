package cn.org.jcloud.jwechat.demo.config;

import cn.org.jcloud.jwechat.WxMainService;
import cn.org.jcloud.jwechat.annotation.WxHandlerScan;
import cn.org.jcloud.jwechat.config.WxConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Title Configuration
 * @Description spring配置类
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
//@PropertySource(value = "classpath:weixin.propertites",ignoreResourceNotFound = true)
@Configuration
@WxHandlerScan({"cn.org.jcloud.jwechat.demo"})
@ComponentScan({"cn.org.jcloud.jwechat"})
public class ApplicationConfig {

    @Bean
    public WxConfig configStorage() {
        WxConfig config = new WxConfig();
        config.setAppid("wx5d57f2472e4236f1");
        config.setSecret("bd19ee0342c53bb05a8adfcc5152cae5");
        config.setToken("huabaide666888");
        config.setEncodingaeskey("vtS3YUxauSP3ZovKj46Hj61tqDFjtQmHSIujRMOoJw0");
        return config;
    }

    @Bean
    public WxMainService wxMainService(WxConfig config) {
        WxMainService wxMainService = new WxMainService(config);
//        wxMainService.setConfig(new   WxConfig("111","2222","3333","4444"));
        return wxMainService;
    }

}

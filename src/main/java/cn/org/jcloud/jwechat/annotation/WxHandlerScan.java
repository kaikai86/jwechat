package cn.org.jcloud.jwechat.annotation;

import cn.org.jcloud.jwechat.config.WxHandlerScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Title WxHandlerScan
 * @Description 微信处理类注解
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({WxHandlerScannerRegistrar.class})
public @interface WxHandlerScan {

    String[] value();
}

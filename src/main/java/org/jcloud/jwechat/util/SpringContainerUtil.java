package org.jcloud.jwechat.util;

import lombok.extern.apachecommons.CommonsLog;
import org.jcloud.jwechat.annotation.WxHandler;

import java.util.Map;

/**
 * @Title SpringUtil
 * @Description Spring工具类
 * @Author ZhangKai
 * @Date 2020/3/30 0030
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@CommonsLog
public class SpringContainerUtil {

    private final static Map<String, Object> handlerBeans;

    static {
        handlerBeans = WxSpringUtil.getApplicationContext().getBeansWithAnnotation(WxHandler.class);
    }

    public static Object getBean(String name) {
        return handlerBeans.get(name);
    }

}

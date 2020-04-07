package cn.org.jcloud.jwechat.annotation;


import cn.org.jcloud.jwechat.enums.EventTypeEnum;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;

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
@Inherited
public @interface WxHandler {
    /**
     * 需要处理的消息类型 消息 or 事件
     */
    MsgTypeEnum value();

    /**
     * 需要处理的事件类型
     */
    EventTypeEnum event() default EventTypeEnum.EVENT;

}

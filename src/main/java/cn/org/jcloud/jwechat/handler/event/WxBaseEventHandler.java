package cn.org.jcloud.jwechat.handler.event;

import cn.org.jcloud.jwechat.bean.message.event.InBaseEvent;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title WxBaseEventHandler
 * @Description 微信事件处理接口
 * @Author ZhangKai
 * @Date 2020/3/27 0027 13:23
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public interface WxBaseEventHandler {
    /**
     * 事件处理抽象方法
     * @param baseEvent     要处理的基本事件
     * @param openId        发消息的微信用户的open_id
     * @param outMessageHelper      回复消息帮助类
     * @param config            微信配置类
     * @return
     */
    OutBaseMessage handle(InBaseEvent baseEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config);


}

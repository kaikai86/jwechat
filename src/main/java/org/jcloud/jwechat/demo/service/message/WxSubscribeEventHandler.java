package org.jcloud.jwechat.demo.service.message;

import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.event.InSubscribeEvent;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.handler.event.AbstractWxSubscribeEventHandler;

/**
 * @Title WxSubscribeEventHandler
 * @Description 微信关注事件处理实现
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxSubscribeEventHandler extends AbstractWxSubscribeEventHandler {


    @Override
    protected OutBaseMessage handleDetail(InSubscribeEvent inSubscribeEvent, String openId, OutMessageHelper outMessageHelper, WxConfig wxConfig) {
        String ticket = inSubscribeEvent.getTicket();
        System.err.println(ticket);
        return null;
    }
}

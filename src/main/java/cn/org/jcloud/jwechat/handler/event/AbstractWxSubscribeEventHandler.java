package cn.org.jcloud.jwechat.handler.event;

import cn.org.jcloud.jwechat.annotation.WxHandler;
import cn.org.jcloud.jwechat.bean.message.event.InBaseEvent;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.enums.EventTypeEnum;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import cn.org.jcloud.jwechat.util.OutMessageHelper;
import cn.org.jcloud.jwechat.bean.message.event.InSubscribeEvent;

/**
 * @Title AbstractWxSubscribeEventHandler
 * @Description 微信订阅事件处理抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(value = MsgTypeEnum.EVENT, event = EventTypeEnum.SUBSCRIBE)
public abstract class AbstractWxSubscribeEventHandler extends AbstractWxEventHandler {

    @Override
    public OutBaseMessage handle(InBaseEvent baseEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InSubscribeEvent) baseEvent, openId,outMessageHelper,config);
    }

    protected abstract OutBaseMessage handleDetail(InSubscribeEvent inSubscribeEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

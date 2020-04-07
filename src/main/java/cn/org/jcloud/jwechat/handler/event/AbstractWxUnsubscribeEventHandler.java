package cn.org.jcloud.jwechat.handler.event;

import cn.org.jcloud.jwechat.annotation.WxHandler;
import cn.org.jcloud.jwechat.bean.message.event.InBaseEvent;
import cn.org.jcloud.jwechat.bean.message.event.InUnsubscribeEvent;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.enums.EventTypeEnum;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title AbstractWxUnsubscribeEventHandler
 * @Description 微信取消订阅事件处理抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(value = MsgTypeEnum.EVENT, event = EventTypeEnum.UNSUBSCRIBE)
public abstract class AbstractWxUnsubscribeEventHandler extends AbstractWxEventHandler {

    @Override
    public OutBaseMessage handle(InBaseEvent baseEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InUnsubscribeEvent) baseEvent, openId,outMessageHelper,config);
    }

    protected abstract OutBaseMessage handleDetail(InUnsubscribeEvent inUnsubscribeEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

package org.jcloud.jwechat.handler.event;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.event.InBaseEvent;
import org.jcloud.jwechat.bean.message.event.InLocationEvent;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.EventTypeEnum;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxLocationEventHandler
 * @Description 微信上报地理位置事件处理抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(value = MsgTypeEnum.EVENT, event = EventTypeEnum.LOCATION)
public abstract class AbstractWxLocationEventHandler extends AbstractWxEventHandler {

    @Override
    public OutBaseMessage handle(InBaseEvent baseEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InLocationEvent) baseEvent, openId,outMessageHelper,config);
    }

    protected abstract OutBaseMessage handleDetail(InLocationEvent inLocationEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

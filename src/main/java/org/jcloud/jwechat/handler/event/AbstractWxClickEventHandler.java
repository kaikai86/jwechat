package org.jcloud.jwechat.handler.event;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.event.InBaseEvent;
import org.jcloud.jwechat.bean.message.event.InClickEvent;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.EventTypeEnum;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxClickEventHandler
 * @Description 微信点击菜单拉取消息时的事件处理抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(value = MsgTypeEnum.EVENT, event = EventTypeEnum.CLICK)
public abstract class AbstractWxClickEventHandler extends AbstractWxEventHandler {

    @Override
    public OutBaseMessage handle(InBaseEvent baseEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InClickEvent) baseEvent, openId,outMessageHelper,config,((InClickEvent) baseEvent).getEventKey());
    }

    protected abstract OutBaseMessage handleDetail(InClickEvent inClickEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config,String eventKey);
}

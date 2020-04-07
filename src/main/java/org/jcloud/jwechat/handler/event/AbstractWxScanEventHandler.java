package org.jcloud.jwechat.handler.event;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.event.InBaseEvent;
import org.jcloud.jwechat.bean.message.event.InScanEvent;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.EventTypeEnum;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxScanEventHandler
 * @Description 微信用户已关注时的事件推送处理抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(value = MsgTypeEnum.EVENT, event = EventTypeEnum.SCAN)
public abstract class AbstractWxScanEventHandler extends AbstractWxEventHandler {

    @Override
    public OutBaseMessage handle(InBaseEvent baseEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InScanEvent) baseEvent, openId,outMessageHelper,config);
    }

    protected abstract OutBaseMessage handleDetail(InScanEvent inScanEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

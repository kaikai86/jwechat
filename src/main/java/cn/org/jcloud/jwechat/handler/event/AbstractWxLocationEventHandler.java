package cn.org.jcloud.jwechat.handler.event;

import cn.org.jcloud.jwechat.annotation.WxHandler;
import cn.org.jcloud.jwechat.bean.event.InBaseEvent;
import cn.org.jcloud.jwechat.bean.event.InLocationEvent;
import cn.org.jcloud.jwechat.bean.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.enums.EventTypeEnum;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

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
        handleDetail((InLocationEvent) baseEvent, openId,outMessageHelper,config);
        return outMessageHelper.replyNullMessage();
    }

    protected abstract void handleDetail(InLocationEvent inLocationEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

package org.jcloud.jwechat.handler.message;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.receive.InBaseMessage;
import org.jcloud.jwechat.bean.message.receive.InLocationMessage;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxLocationMessageHandler
 * @Description 微信位置消息抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(MsgTypeEnum.LOCATION)
public abstract class AbstractWxLocationMessageHandler extends AbstractWxMessageHandler {

    @Override
    public OutBaseMessage handle(InBaseMessage baseMessage, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InLocationMessage) baseMessage, openId, outMessageHelper,config);
    }

    /**
     * 具体的处理消息类
     *
     * @param locationMessage 微信发送的位置消息
     * @param openId      微信用户的id
     * @return
     */
    protected abstract OutBaseMessage handleDetail(InLocationMessage locationMessage, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

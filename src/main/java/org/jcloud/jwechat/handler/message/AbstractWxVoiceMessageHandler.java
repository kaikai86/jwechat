package org.jcloud.jwechat.handler.message;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.receive.InBaseMessage;
import org.jcloud.jwechat.bean.message.receive.InVoiceMessage;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxVoiceMessageHandler
 * @Description 微信语音消息抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(MsgTypeEnum.VOICE)
public abstract class AbstractWxVoiceMessageHandler extends AbstractWxMessageHandler {

    @Override
    public OutBaseMessage handle(InBaseMessage baseMessage, String openId, OutMessageHelper outMessageHelper, WxConfig wxConfig) {
        return handleDetail((InVoiceMessage) baseMessage, openId, outMessageHelper,wxConfig);
    }

    /**
     * 具体的处理消息类
     *
     * @param voiceMessage 微信发送的语音消息
     * @param openId      微信用户的id
     * @return
     */
    protected abstract OutBaseMessage handleDetail(InVoiceMessage voiceMessage, String openId, OutMessageHelper outMessageHelper, WxConfig wxConfig);
}

package org.jcloud.jwechat.handler.message;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.receive.InBaseMessage;
import org.jcloud.jwechat.bean.message.receive.InShortVideoMessage;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxShortVideoMessageHandler
 * @Description 微信短视频消息抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(MsgTypeEnum.SHORT_VIDEO)
public abstract class AbstractWxShortVideoMessageHandler extends AbstractWxMessageHandler {

    @Override
    public OutBaseMessage handle(InBaseMessage baseMessage, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InShortVideoMessage) baseMessage, openId, outMessageHelper,config);
    }

    /**
     * 具体的处理消息类
     * @param videoShortMessage 微信发送的短视频消息
     * @param openId      微信用户的id
     * @return
     */
    protected abstract OutBaseMessage handleDetail(InShortVideoMessage videoShortMessage, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

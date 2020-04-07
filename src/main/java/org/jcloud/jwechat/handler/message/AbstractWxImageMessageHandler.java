package org.jcloud.jwechat.handler.message;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.receive.InBaseMessage;
import org.jcloud.jwechat.bean.message.receive.InImageMessage;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxImageMessageHandler
 * @Description 微信图片消息抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(MsgTypeEnum.IMAGE)
public abstract class AbstractWxImageMessageHandler extends AbstractWxMessageHandler {

    @Override
    public OutBaseMessage handle(InBaseMessage baseMessage, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return handleDetail((InImageMessage) baseMessage, openId, outMessageHelper,config);
    }

    /**
     * 具体的处理消息类
     *
     * @param imageMessage 微信发送的图片消息
     * @param openId      微信用户的id
     * @return
     */
    protected abstract OutBaseMessage handleDetail(InImageMessage imageMessage, String openId, OutMessageHelper outMessageHelper, WxConfig config);
}

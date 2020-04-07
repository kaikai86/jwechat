package org.jcloud.jwechat.handler.message;

import org.jcloud.jwechat.annotation.WxHandler;
import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.receive.InBaseMessage;
import org.jcloud.jwechat.bean.message.receive.InTextMessage;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;
import org.jcloud.jwechat.enums.MsgTypeEnum;

/**
 * @Title AbstractWxMessageHandler
 * @Description 微信文本消息抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(MsgTypeEnum.TEXT)
public abstract class AbstractWxTextMessageHandler extends AbstractWxMessageHandler {

    @Override
    public OutBaseMessage handle(InBaseMessage baseMessage, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        InTextMessage inTextMessage = (InTextMessage) baseMessage;
        return handleDetail((InTextMessage) baseMessage, openId,inTextMessage.getContent(), outMessageHelper,config);
    }

    /**
     * 具体的处理消息类
     *
     * @param textMessage 微信用户发送的消息对象
     * @param openId      微信用户的id
     * @param content     微信用户发送的文本内容
     * @param outMessageHelper     回复消息辅助对象
     * @param config     微信配置类
     * @return
     */
    protected abstract OutBaseMessage handleDetail(InTextMessage textMessage, String openId, String content, OutMessageHelper outMessageHelper, WxConfig config);
}

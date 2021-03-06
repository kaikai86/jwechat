package cn.org.jcloud.jwechat.handler.message;

import cn.org.jcloud.jwechat.annotation.WxHandler;
import cn.org.jcloud.jwechat.bean.receive.InBaseMessage;
import cn.org.jcloud.jwechat.bean.receive.InImageMessage;
import cn.org.jcloud.jwechat.bean.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

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

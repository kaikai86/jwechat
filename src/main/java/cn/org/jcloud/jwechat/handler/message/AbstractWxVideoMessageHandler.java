package cn.org.jcloud.jwechat.handler.message;

import cn.org.jcloud.jwechat.annotation.WxHandler;
import cn.org.jcloud.jwechat.bean.receive.InBaseMessage;
import cn.org.jcloud.jwechat.bean.receive.InVideoMessage;
import cn.org.jcloud.jwechat.bean.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title AbstractWxVideoMessageHandler
 * @Description 微信视频消息抽象类
 * @Author ZhangKai
 * @Date 2020/3/27 0027
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@WxHandler(MsgTypeEnum.VIDEO)
public abstract class AbstractWxVideoMessageHandler extends AbstractWxMessageHandler {

    @Override
    public OutBaseMessage handle(InBaseMessage baseMessage, String openId, OutMessageHelper outMessageHelper, WxConfig wxConfig) {
        return handleDetail((InVideoMessage) baseMessage, openId, outMessageHelper,wxConfig);
    }

    /**
     * 具体的处理消息类
     * @param videoMessage 微信发送的视频消息
     * @param openId      微信用户的id
     * @return
     */
    protected abstract OutBaseMessage handleDetail(InVideoMessage videoMessage, String openId, OutMessageHelper outMessageHelper, WxConfig wxConfig);
}

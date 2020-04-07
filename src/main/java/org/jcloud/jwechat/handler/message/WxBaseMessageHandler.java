package org.jcloud.jwechat.handler.message;

import org.jcloud.jwechat.util.OutMessageHelper;
import org.jcloud.jwechat.bean.message.receive.InBaseMessage;
import org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import org.jcloud.jwechat.config.WxConfig;

/**
 * @Title WxMessageHandler
 * @Description 微信消息处理接口
 * @Author ZhangKai
 * @Date 2020/3/27 0027 13:23
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public interface WxBaseMessageHandler {


    OutBaseMessage handle(InBaseMessage baseMessage, String openId, OutMessageHelper outMessageHelper, WxConfig wxConfig);

}

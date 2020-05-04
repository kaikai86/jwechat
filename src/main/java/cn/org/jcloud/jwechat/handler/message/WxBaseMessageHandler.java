package cn.org.jcloud.jwechat.handler.message;

import cn.org.jcloud.jwechat.bean.receive.InBaseMessage;
import cn.org.jcloud.jwechat.bean.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

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

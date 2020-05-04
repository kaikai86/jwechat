package cn.org.jcloud.jwechat.demo.service;

import cn.hutool.json.JSONUtil;
import cn.org.jcloud.jwechat.bean.event.InClickEvent;
import cn.org.jcloud.jwechat.bean.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.handler.event.AbstractWxClickEventHandler;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title WxSubscribeEventHandler
 * @Description 微信关注事件处理实现
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxClickEventHandler extends AbstractWxClickEventHandler {


    @Override
    protected OutBaseMessage handleDetail(InClickEvent inClickEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config, String eventKey) {
        System.err.println(JSONUtil.toJsonStr(inClickEvent));
        return null;
    }
}

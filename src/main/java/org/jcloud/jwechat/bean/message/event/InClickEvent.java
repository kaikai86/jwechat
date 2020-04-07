package org.jcloud.jwechat.bean.message.event;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InClickEvent
 * @Description 微信-普通事件处理-点击菜单拉取消息时的事件推送
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InClickEvent extends InBaseEvent {

    // 事件KEY值，与自定义菜单接口中KEY值对应
    @XmlElement(name = "EventKey")
    private String eventKey;

}

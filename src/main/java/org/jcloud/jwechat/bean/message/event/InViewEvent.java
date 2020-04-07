package org.jcloud.jwechat.bean.message.event;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InClickEvent
 * @Description 微信-普通事件处理-点击菜单跳转链接时的事件推送
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InViewEvent extends InBaseEvent {

    // 事件KEY值，设置的跳转URL
    @XmlElement(name = "EventKey")
    private String eventKey;

    // 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
    @XmlElement(name = "MenuID", required = false)
    private String menuID;

}

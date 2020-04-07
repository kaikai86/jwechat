package cn.org.jcloud.jwechat.bean.message.event;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @Title InBaseEvent
 * @Description 微信-普通事件处理-基类事件
 * @Author ZhangKai
 * @Date 2020/3/30 0030
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class InBaseEvent {

    // 开发者微信号
    @XmlElement(name = "ToUserName")
    private String toUserName;
    // OpenID
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    // 消息创建时间 （整型）String得容错性更高
    @XmlElement(name = "CreateTime")
    private String createTime;
    // 消息类型，event
    @XmlElement(name = "MsgType")
    private String msgType;
    // 事件类型
    @XmlElement(name = "Event")
    private String event;
}

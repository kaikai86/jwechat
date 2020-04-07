package cn.org.jcloud.jwechat.bean.message.receive;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * @Title InBaseMessage
 * @Description 微信-普通消息处理-基类消息
 * @Author ZhangKai
 * @Date 2020/3/27
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlSeeAlso({
//		InTextMessage.class,
//		InImageMessage.class,
//})
public class InBaseMessage {

    /**
     * 开发者微信号
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private String createTime;

    /**
     * 消息类型
     */
    @XmlElement(name = "MsgType")
    private String msgType;

    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private String msgId;
}

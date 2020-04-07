package org.jcloud.jwechat.bean.message.receive;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InTextMessage
 * @Description 微信-普通消息处理-文本消息
 * @Author ZhangKai
 * @Date 2020/3/27
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InTextMessage extends InBaseMessage {

    /**
     * 文本消息内容
     */
    @XmlElement(name = "Content")
    private String content;

}

package org.jcloud.jwechat.bean.message.receive;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InLinkMessage
 * @Description 微信-普通消息处理-链接消息
 * @Author ZhangKai
 * @Date 2020/3/27
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InLinkMessage extends InBaseMessage {

    /**
     * 消息标题
     */
    @XmlElement(name = "Title")
    private String title;

    /**
     * 消息描述
     */
    @XmlElement(name = "Description")
    private String description;

    /**
     * 消息链接
     */
    @XmlElement(name = "Url")
    private String url;


}

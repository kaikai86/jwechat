package org.jcloud.jwechat.bean.message.send;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jcloud.jwechat.enums.MsgTypeEnum;
import org.jcloud.jwechat.util.xml.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @Title OutTextMessage
 * @Description 微信-消息回复-文本消息
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
@NoArgsConstructor
public class OutTextMessage extends OutBaseMessage {

    @XmlElement(name = "Content")
    @XmlJavaTypeAdapter(value= CDataAdapter.class)
    private String content;


    public OutTextMessage(MsgTypeEnum msgType, String toUserName, String fromUserName,String content) {
        super(msgType, toUserName, fromUserName);
        this.content = content;
    }
}

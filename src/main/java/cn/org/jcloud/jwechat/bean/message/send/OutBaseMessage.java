package cn.org.jcloud.jwechat.bean.message.send;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import cn.org.jcloud.jwechat.util.xml.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * @Title OutBaseMessage
 * @Description 微信-消息回复-基类消息
 * @Author ZhangKai
 * @Date 2020/3/27
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class OutBaseMessage implements Serializable {

    /**
     * 接收方帐号（收到的OpenID）
     */
    @XmlElement(name = "ToUserName")
    @XmlJavaTypeAdapter(value= CDataAdapter.class)
    private String toUserName;

    /**
     * 开发者微信号
     */
    @XmlElement(name = "FromUserName")
    @XmlJavaTypeAdapter(value= CDataAdapter.class)
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
    @XmlJavaTypeAdapter(value= CDataAdapter.class)
    private String msgType;

    public OutBaseMessage(MsgTypeEnum msgType) {
        this.msgType = msgType.getName();
        this.createTime = now();
    }

    public OutBaseMessage(MsgTypeEnum msgType, String toUserName, String fromUserName) {
        this(msgType);
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
    }

    private String now() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}

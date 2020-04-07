package cn.org.jcloud.jwechat.bean.message.send;

import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import cn.org.jcloud.jwechat.util.xml.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @Title OutVoiceMessage
 * @Description 微信-消息回复-语音消息
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
public class OutVoiceMessage extends OutBaseMessage {

    @XmlElement(name = "Voice")
    private Voice voice;

    public OutVoiceMessage(MsgTypeEnum msgType, String toUserName, String fromUserName, Voice voice) {
        super(msgType, toUserName, fromUserName);
        this.voice = voice;
    }

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Voice {
        @XmlElement(name = "MediaId")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String mediaId;
    }
}

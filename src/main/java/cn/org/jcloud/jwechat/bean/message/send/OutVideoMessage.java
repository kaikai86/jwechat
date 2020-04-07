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
 * @Title OutVideoMessage
 * @Description 微信-消息回复-视频消息
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
public class OutVideoMessage extends OutBaseMessage {

    @XmlElement(name = "Video")
    private Video video;

    public OutVideoMessage(MsgTypeEnum msgType, String toUserName, String fromUserName, Video video) {
        super(msgType, toUserName, fromUserName);
        this.video = video;
    }

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Video {
        @XmlElement(name = "MediaId")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String mediaId;

        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String title;

        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String description;

    }
}

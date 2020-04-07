package org.jcloud.jwechat.bean.message.send;

import lombok.AllArgsConstructor;
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
 * @Title OutMusicMessage
 * @Description 微信-消息回复-音乐消息
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
@NoArgsConstructor
public class OutMusicMessage extends OutBaseMessage {

    @XmlElement(name = "Music")
    private Music music;

    public OutMusicMessage(MsgTypeEnum msgType, String toUserName, String fromUserName, Music music) {
        super(msgType, toUserName, fromUserName);
        this.music = music;
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Music {

        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String title;
        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String description;
        @XmlElement(name = "MusicURL")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String musicUrl;
        // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
        @XmlElement(name = "HQMusicUrl")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String hQMusicUrl;
        // 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
        @XmlElement(name = "ThumbMediaId")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String thumbMediaId;
    }

}

package cn.org.jcloud.jwechat.bean.message.receive;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InShortVideoMessage
 * @Description 微信-普通消息处理-短视频消息
 * @Author ZhangKai
 * @Date 2020/3/27
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InShortVideoMessage extends InBaseMessage {

    /**
     * 视频消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

}

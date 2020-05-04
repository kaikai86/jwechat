package cn.org.jcloud.jwechat.bean.receive;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InVoiceMessage
 * @Description 微信-普通消息处理-声音消息
 * @Author ZhangKai
 * @Date 2020/3/27
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InVoiceMessage extends InBaseMessage {

    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "Format")
    private String format;
    /**
     * 语音识别结果，UTF8编码
     */
    @XmlElement(name = "Recognition")
    private String recognition;


}

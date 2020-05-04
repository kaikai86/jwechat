package cn.org.jcloud.jwechat.bean.receive;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InLocationMessage
 * @Description 微信-普通消息处理-地理位置消息
 * @Author ZhangKai
 * @Date 2020/3/27
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InLocationMessage extends InBaseMessage {

    /**
     * 地理位置维度
     */
    @XmlElement(name = "Location_X")
    private String locationX;

    /**
     * 地理位置经度
     */
    @XmlElement(name = "Location_Y")
    private String locationY;

    /**
     * 地图缩放大小
     */
    @XmlElement(name = "Scale")
    private String scale;

    /**
     * 地理位置信息
     */
    @XmlElement(name = "Label")
    private String label;

}

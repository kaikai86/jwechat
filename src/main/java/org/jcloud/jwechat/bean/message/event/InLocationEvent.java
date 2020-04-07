package org.jcloud.jwechat.bean.message.event;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InLocationEvent
 * @Description 微信-普通事件处理-上报地理位置事件推送
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InLocationEvent extends InBaseEvent {

    // 地理位置纬度
    @XmlElement(name = "Latitude")
    private String latitude;
    // 地理位置经度
    @XmlElement(name = "Longitude")
    private String longitude;
    // 地理位置精度
    @XmlElement(name = "Precision")
    private String precision;

}

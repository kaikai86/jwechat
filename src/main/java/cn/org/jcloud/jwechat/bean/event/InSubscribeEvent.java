package cn.org.jcloud.jwechat.bean.event;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title InSubscribeEvent
 * @Description 微信-普通事件处理-用户关注时的事件推送
 * 微信-普通事件处理-(扫描带参数二维码事件)用户未关注时，进行关注后的事件推送
 * @Author ZhangKai
 * @Date 2020/3/30 0030
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class InSubscribeEvent extends InBaseEvent {

    // 二维码的ticket，可用来换取二维码图片
    @XmlElement(name = "Ticket", required = false)
    private String ticket;
    // 事件类型，subscribe(订阅)、unsubscribe(取消订阅)、事件KEY值，qrscene_为前缀，后面为二维码的参数值、
    @XmlElement(name = "EventKey", required = false)
    private String eventKey;

}

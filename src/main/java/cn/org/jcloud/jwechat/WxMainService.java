package cn.org.jcloud.jwechat;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.org.jcloud.jwechat.bean.event.*;
import cn.org.jcloud.jwechat.bean.receive.*;
import cn.org.jcloud.jwechat.bean.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.constant.WxMessageConstant;
import cn.org.jcloud.jwechat.enums.EventTypeEnum;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import cn.org.jcloud.jwechat.handler.event.WxBaseEventHandler;
import cn.org.jcloud.jwechat.handler.message.WxBaseMessageHandler;
import cn.org.jcloud.jwechat.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.InitializingBean;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;


/**
 * @Title WxMainService
 * @Description 微信核心服务类
 * @Author ZhangKai
 * @Date 2020/3/30 0030
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@CommonsLog
@Getter
@Setter
@AllArgsConstructor
public class WxMainService implements InitializingBean {

    private WxConfig config;

    /**
     * 验证身份
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public boolean check(String timestamp, String nonce, String signature) {
        //检测Config对象是否有效
        return SignUtil.checkSignature(this.config.getToken(),signature,timestamp,nonce);
    }

    /**
     * 处理用户明文信息
     * @param requestBody   微信用户发送过来的xml数据
     * @return
     * @throws RuntimeException
     */
    public String handle(String requestBody) {
        return handle(null,requestBody,null,null,null);
    }

    /**
     * 处理用户信息
     * @param encryptType   加密类型，密文为 aes，明文为null
     * @param requestBody   微信用户发送过来的xml数据
     * @param timestamp     时间戳     当加密类型为aes时，不能为空
     * @param nonce         随机数     当加密类型为aes时，不能为空
     * @param msgSignature  消息体签名，用于验证消息体的正确性   当加密类型为aes时，不能为空
     * @return
     * @throws RuntimeException
     */
    public String handle(String encryptType,String requestBody,String timestamp,String nonce,String msgSignature) {
        //1、验证消息是否合法
        if (StrUtil.isBlank(requestBody)) {
            return "";
        }
        if (!StrUtil.isNullOrUndefined(encryptType) && !StrUtil.equals("aes",encryptType)) {
            return "";
        }
        String xmlInfo = requestBody;
        config.setCipher(false);
        if(StrUtil.equals("aes",encryptType)) {
            if(StrUtil.isBlank(timestamp) || StrUtil.isBlank(nonce) || StrUtil.isBlank(msgSignature)){
                return "";
            }
            xmlInfo = MsgEncryptUtil.decrypt(requestBody, timestamp, nonce, msgSignature, this.config);
            config.setCipher(true);
            log.info("接收到的微信信息解密后结果-->"+xmlInfo);
        }

        String reply = "";
        try {
            //2、根据xmlInfo中的MsgType获取对应枚举对象
            MsgTypeEnum msgTypeEnum = getMsgTypeEnum(xmlInfo);
            //3、解析xml数据并进行业务处理
            reply = handleXmlInfo(msgTypeEnum, xmlInfo,timestamp,nonce);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("处理信息失败");
        }
        return reply;
    }

    /**
     * 根据xml类型获取对应的消息枚举类
     *
     * @param xmlInfo 微信发送的xml信息
     * @return
     */
    private MsgTypeEnum getMsgTypeEnum(String xmlInfo) {
        Document document = XmlUtil.parseXml(xmlInfo);
        String msgType = (String) XmlUtil.getByXPath("//xml/MsgType", document, XPathConstants.STRING);
        return MsgTypeEnum.getMsgTypeEnumByName(msgType);
    }

    /**
     * 根据xml类型获取对应的事件枚举类
     *
     * @param xmlInfo 微信发送的xml信息
     * @return
     */
    private EventTypeEnum getEventTypeEnum(String xmlInfo) {
        Document document = XmlUtil.parseXml(xmlInfo);
        String eventType = (String) XmlUtil.getByXPath("//xml/Event", document, XPathConstants.STRING);
        return EventTypeEnum.getEventTypeEnumByName(eventType);
    }

    /**
     * 处理xml信息
     *
     * @param msgTypeEnum 消息枚举类
     * @param xmlInfo     微信发送的xml信息
     * @return
     */
    private String handleXmlInfo(MsgTypeEnum msgTypeEnum, String xmlInfo,String timestamp,String nonce) {
        if (StrUtil.isBlank(xmlInfo) || ObjectUtil.isNull(msgTypeEnum)) {
            return "";
        }
        OutBaseMessage outBaseMessage = null;
        if (msgTypeEnum.equals(MsgTypeEnum.EVENT)) {
            EventTypeEnum eventTypeEnum = getEventTypeEnum(xmlInfo);
            InBaseEvent baseEvent = convertInBaseEvent(xmlInfo, eventTypeEnum);
            if (ObjectUtil.isNotNull(baseEvent)) {
                String beanName = eventTypeEnum.getName().toLowerCase().concat(WxMessageConstant.EVENT_HANDLER_BEAN_POST_FIX);
                WxBaseEventHandler eventHandlerBean = (WxBaseEventHandler) SpringContainerUtil.getBean(beanName);
                if (ObjectUtil.isNotNull(eventHandlerBean)) {
                    OutMessageHelper outMessageHelper = OutMessageHelper.build(baseEvent.getFromUserName(), baseEvent.getToUserName());
                    outBaseMessage = eventHandlerBean.handle(baseEvent, baseEvent.getFromUserName(), outMessageHelper,config);
                }
            }
        } else {
            InBaseMessage baseMessage = convertInBaseMessage(xmlInfo, msgTypeEnum);
            if (ObjectUtil.isNotNull(baseMessage)) {
                String beanName = msgTypeEnum.getName().toLowerCase().concat(WxMessageConstant.MESSAGE_HANDLER_BEAN_POST_FIX);
                WxBaseMessageHandler messageHandlerBean = (WxBaseMessageHandler) SpringContainerUtil.getBean(beanName);
                if (ObjectUtil.isNotNull(messageHandlerBean)) {
                    OutMessageHelper outMessageHelper = OutMessageHelper.build(baseMessage.getFromUserName(), baseMessage.getToUserName());
                    outBaseMessage = messageHandlerBean.handle(baseMessage, baseMessage.getFromUserName(), outMessageHelper,config);
                }
            }
        }
        String reply = XmlUtils.convertToXml(outBaseMessage);
        if (StrUtil.isNotBlank(reply) && config.isCipher()) {
            reply = MsgEncryptUtil.encrypt(reply,timestamp,nonce,config);
        }
        return reply;
    }

    /**
     * 根据枚举类型转换成对应消息对象
     *
     * @param xmlInfo     微信发送的xml信息
     * @param msgTypeEnum 消息枚举类
     * @return
     */
    private InBaseMessage convertInBaseMessage(String xmlInfo, MsgTypeEnum msgTypeEnum) {
        if (StrUtil.isBlank(xmlInfo) || ObjectUtil.isNull(msgTypeEnum)) {
            return null;
        }
        InBaseMessage inBaseMessage = null;
        switch (msgTypeEnum) {
            case MsgType:
                break;
            case MSGMENU:
                break;
            case EVENT:
                break;
            case TEXT:
                inBaseMessage = XmlUtils.xmlToBean(InTextMessage.class, xmlInfo);
                break;
            case LINK:
                inBaseMessage = XmlUtils.xmlToBean(InLinkMessage.class, xmlInfo);
                break;
            case IMAGE:
                inBaseMessage = XmlUtils.xmlToBean(InImageMessage.class, xmlInfo);
                break;
            case VOICE:
                inBaseMessage = XmlUtils.xmlToBean(InVoiceMessage.class, xmlInfo);
                break;
            case VIDEO:
                inBaseMessage = XmlUtils.xmlToBean(InVideoMessage.class, xmlInfo);
                break;
            case MUSIC:
                break;
            case NEWS:
                break;
            case MPNEWS:
                break;
            case LOCATION:
                inBaseMessage = XmlUtils.xmlToBean(InLocationMessage.class, xmlInfo);
                break;
            case SHORT_VIDEO:
                inBaseMessage = XmlUtils.xmlToBean(InShortVideoMessage.class, xmlInfo);
                break;
            case WXCARD:
                break;
            case MINIPROGRAMPAGE:
                break;
            default:
                log.warn("new MsgType-->:".concat(msgTypeEnum.getName()).concat(" don't use"));
//                throw new IllegalStateException("Unexpected value: " + msgTypeEnum.getName());
        }
        return inBaseMessage;
    }

    /**
     * 根据枚举类型转换成对应事件对象
     *
     * @param xmlInfo       微信发送的xml信息
     * @param eventTypeEnum 消息枚举类
     * @return
     */
    private InBaseEvent convertInBaseEvent(String xmlInfo, EventTypeEnum eventTypeEnum) {
        if (StrUtil.isBlank(xmlInfo) || ObjectUtil.isNull(eventTypeEnum)) {
            return null;
        }
        InBaseEvent inBaseEvent = null;
        switch (eventTypeEnum) {
            case EVENT:
                break;
            case CLICK:
                inBaseEvent = XmlUtils.xmlToBean(InClickEvent.class, xmlInfo);
                break;
            case VIEW:
                inBaseEvent = XmlUtils.xmlToBean(InViewEvent.class, xmlInfo);
                break;
            case SUBSCRIBE:
                inBaseEvent = XmlUtils.xmlToBean(InSubscribeEvent.class, xmlInfo);
                break;
            case SCAN:
                inBaseEvent = XmlUtils.xmlToBean(InScanEvent.class, xmlInfo);
                break;
            case UNSUBSCRIBE:
                inBaseEvent = XmlUtils.xmlToBean(InUnsubscribeEvent.class, xmlInfo);
                break;
            case LOCATION:
                inBaseEvent = XmlUtils.xmlToBean(InLocationEvent.class, xmlInfo);
                break;
            case SCANCODE_PUSH:
                break;
            case SCANCODE_WAITMSG:
                break;
            case PIC_SYSPHOTO:
                break;
            case PIC_PHOTO_OR_ALBUM:
                break;
            case PIC_WEIXIN:
                break;
            case LOCATION_SELECT:
                break;
            case VIEW_MINIPROGRAM:
                break;
            default:
                log.warn("new EventType-->:".concat(eventTypeEnum.getName()).concat(" don't use"));
//                throw new IllegalStateException("Unexpected value: " + eventTypeEnum);
        }
        return inBaseEvent;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (config == null) {
            throw new RuntimeException("WxConfig is null.Please check your properties...");
        }
    }
}

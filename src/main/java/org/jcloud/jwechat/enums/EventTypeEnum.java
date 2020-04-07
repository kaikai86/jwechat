package org.jcloud.jwechat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title EventTypeEnum
 * @Description 事件类型枚举
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@AllArgsConstructor
public enum EventTypeEnum {
    /**
     * 事件类型主要从Event中做识别
     */
    EVENT("event", "事件"),

    /**
     * 订阅
     */
    SUBSCRIBE("subscribe", "订阅事件"),
    /**
     * 取消订阅
     */
    UNSUBSCRIBE("unsubscribe", "取消订阅事件"),
    /**
     * 上报地理位置事件
     */
    LOCATION("LOCATION", "上报地理位置事件"),
    /**
     * 自定义菜单事件-点击菜单拉取消息时的事件推送
     */
    CLICK("CLICK", "自定义菜单事件-点击菜单拉取消息时的事件推送"),
    /**
     * 自定义菜单事件-点击菜单跳转链接时的事件推送
     */
    VIEW("VIEW", "自定义菜单事件-点击菜单跳转链接时的事件推送"),
    /**
     * 扫描带参数二维码事件-用户已关注时的事件推送
     */
    SCAN("SCAN", "扫描带参数二维码事件-用户已关注时的事件推送"),
    /**
     * 扫码推事件的事件推送
     */
    SCANCODE_PUSH("scancode_push", "扫码推事件的事件推送"),
    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     */
    SCANCODE_WAITMSG("scancode_waitmsg", "扫码推事件且弹出“消息接收中”提示框的事件推送"),
    /**
     * 扫码推事件的事件推送
     */
    PIC_SYSPHOTO("pic_sysphoto", "弹出系统拍照发图的事件推送"),
    /**
     * 弹出拍照或者相册发图的事件推送
     */
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album", "弹出拍照或者相册发图的事件推送"),
    /**
     * 弹出微信相册发图器的事件推送
     */
    PIC_WEIXIN("pic_weixin", "弹出微信相册发图器的事件推送"),
    /**
     * 弹出地理位置选择器的事件推送
     */
    LOCATION_SELECT("location_select", "弹出地理位置选择器的事件推送"),
    /**
     * 点击菜单跳转小程序的事件推送
     */
    VIEW_MINIPROGRAM("view_miniprogram", "点击菜单跳转小程序的事件推送");
    private String name;
    private String description;

    public static boolean containsEventType(String typeStr) {
        EventTypeEnum[] values = values();
        for (EventTypeEnum eventTypeEnum : values) {
            if (eventTypeEnum.getName().equals(typeStr)) {
                return true;
            }
            ;
        }
        return false;
    }

    public static EventTypeEnum getEventTypeEnumByName(String msgType) {
        if (msgType == null || "".equals(msgType)) {
            return null;
        }
        EventTypeEnum[] values = values();
        for (EventTypeEnum eventTypeEnum : values) {
            if (eventTypeEnum.getName().equals(msgType)) {
                return eventTypeEnum;
            }
        }
        return null;
    }

}

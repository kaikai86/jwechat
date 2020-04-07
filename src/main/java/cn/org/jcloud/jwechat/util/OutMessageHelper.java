package cn.org.jcloud.jwechat.util;

import cn.hutool.core.bean.BeanUtil;
import cn.org.jcloud.jwechat.bean.message.dto.*;
import cn.org.jcloud.jwechat.bean.message.send.*;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title OutMessageHelper
 * @Description 回复消息辅助类
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
public class OutMessageHelper {

    private String toUserName;

    private String fromUserName;

    public OutMessageHelper(String toUserName, String fromUserName) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
    }

    /**
     * 不回復任何消息
     * @return
     */
    public OutBaseMessage replyNullMessage() {
        return null;
    }

    /**
     * 回復文本消息
     * @param content   回復內容
     * @return
     */
    public OutBaseMessage replyTextMessage(String content) {
        return new OutTextMessage(MsgTypeEnum.TEXT,toUserName,fromUserName,content);
    }

    /**
     * 回復图片消息
     * @param imageDTO   要回复的图片信息对象
     * @return
     */
    public OutBaseMessage replyImageMessage(ImageDTO imageDTO) {
        OutImageMessage.Image image = new OutImageMessage.Image();
        BeanUtil.copyProperties(imageDTO, image);
        return new OutImageMessage(MsgTypeEnum.IMAGE,toUserName,fromUserName,image);
    }

    /**
     * 回復图片消息
     * @param mediaId   要回复的图片素材id
     * @return
     */
    public OutBaseMessage replyImageMessage(String mediaId) {
        return new OutImageMessage(MsgTypeEnum.IMAGE,toUserName,fromUserName,new OutImageMessage.Image(mediaId));
    }

    /**
     * 回复语音消息
     * @param mediaId   要回复的语音素材id
     * @return
     */
    public OutBaseMessage replyVoiceMessage(String mediaId) {
        return new OutVoiceMessage(MsgTypeEnum.VOICE,toUserName,fromUserName,new OutVoiceMessage.Voice(mediaId));
    }

    /**
     * 回复语音消息
     * @param voiceDTO   要回复的语音信息对象
     * @return
     */
    public OutBaseMessage replyVoiceMessage(VoiceDTO voiceDTO) {
        OutVoiceMessage.Voice voice = new OutVoiceMessage.Voice();
        BeanUtil.copyProperties(voiceDTO,voice);
        return new OutVoiceMessage(MsgTypeEnum.VOICE,toUserName,fromUserName,voice);
    }

    /**
     * 回复视频消息
     * @param mediaId   要回复的视频素材id
     * @param title   视频消息的标题
     * @param description   视频消息的描述
     * @return
     */
    public OutBaseMessage replyVideoMessage(String mediaId,String title,String description) {
        return new OutVideoMessage(MsgTypeEnum.VIDEO, toUserName, fromUserName, new OutVideoMessage.Video(mediaId, title, description));
    }

    /**
     * 回复视频消息
     * @param videoDTO   要回复的视频信息对象
     * @return
     */
    public OutBaseMessage replyVideoMessage(VideoDTO videoDTO) {
        OutVideoMessage.Video video = new OutVideoMessage.Video();
        BeanUtil.copyProperties(videoDTO,video);
        return  new OutVideoMessage(MsgTypeEnum.VIDEO, toUserName, fromUserName,video);
    }

    /**
     * 回复音乐消息
     * @param title   音乐标题
     * @param description   音乐描述
     * @param musicUrl   音乐链接
     * @param musicUrlHQ   高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param thumbMediaId   缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     * @return
     */
    public OutBaseMessage replyMusicMessage(String title,String description,String musicUrl,String musicUrlHQ,String thumbMediaId) {
        return new OutMusicMessage(MsgTypeEnum.MUSIC, toUserName, fromUserName, new OutMusicMessage.Music(title, description, musicUrl, musicUrlHQ, thumbMediaId));
    }

    /**
     * 回复音乐消息
     * @param musicDTO   要回复的音乐信息对象
     * @return
     */
    public OutBaseMessage replyMusicMessage(MusicDTO musicDTO) {
        OutMusicMessage.Music music = new OutMusicMessage.Music();
        BeanUtil.copyProperties(musicDTO,music);
        return new OutMusicMessage(MsgTypeEnum.MUSIC, toUserName, fromUserName, music);
    }

    /**
     * 回复图文消息
     * @param articleDTOS   图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     * @return
     */
    public OutBaseMessage replyNewsMessage(List<ArticleDTO> articleDTOS) {
        List<OutNewsMessage.Article> articles = new LinkedList<>();
        for (ArticleDTO articleDTO : articleDTOS) {
            OutNewsMessage.Article article = new OutNewsMessage.Article();
            BeanUtil.copyProperties(articleDTO,article);
            articles.add(article);
        }
        return  new OutNewsMessage(MsgTypeEnum.NEWS, toUserName, fromUserName, articles);
    }


    public static OutMessageHelper build(String toUserName,String fromUserName) {
        return new OutMessageHelper(toUserName,fromUserName);
    }
}

package cn.org.jcloud.jwechat.bean.dto;

import lombok.*;

/**
 * @Title MusicDTO
 * @Description 音乐传输对象
 * @Author ZhangKai
 * @Date 2020/4/1 0001
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicDTO {
    /**
     * 必填 否 音乐标题
     */
    private String title;

    /**
     * 必填 否 音乐描述
     */
    private String description;

    /**
     * 必填 否 音乐链接
     */
    private String musicUrl;

    /**
     * 必填 否 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    private String hQMusicUrl;

    /**
     * 必填 是 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id 必须
     */
    private String thumbMediaId;
}

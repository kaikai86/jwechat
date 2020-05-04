package cn.org.jcloud.jwechat.bean.dto;

import lombok.*;

/**
 * @Title VideoDTO
 * @Description 视频传输对象
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
public class VideoDTO {

    /**
     * 必填 是 通过素材管理中的接口上传多媒体文件，得到的id。
     */
    private String mediaId;

    /**
     * 必填 否 视频消息的标题
     */
    private String title;

    /**
     * 必填 否 视频消息的描述
     */
    private String description;

}

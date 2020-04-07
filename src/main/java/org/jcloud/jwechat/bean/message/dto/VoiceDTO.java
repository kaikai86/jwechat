package org.jcloud.jwechat.bean.message.dto;

import lombok.*;

/**
 * @Title VoiceDTO
 * @Description 语音传输对象
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
public class VoiceDTO {

    /**
     * 必填 是 通过素材管理中的接口上传多媒体文件，得到的id。
     */
    private String mediaId;
}

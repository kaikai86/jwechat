package cn.org.jcloud.jwechat.bean.dto;

import lombok.*;

/**
 * @Title ImageDTO
 * @Description 图片传输对象
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    /**
     * 必填 是 通过素材管理中的接口上传多媒体文件，得到的id。
     */
    private String mediaId;
}

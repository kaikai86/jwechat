package cn.org.jcloud.jwechat.bean.dto;

import lombok.*;

/**
 * @Title ArticleDto
 * @Description 图文传输对象
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
public class ArticleDTO {
    /**
     * 必填 是 图文消息标题
     */
    private String title;

    /**
     * 必填 是 图文消息描述
     */
    private String description;

    /**
     * 必填 是 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    private String picUrl;

    /**
     * 必填 是 点击图文消息跳转链接
     */
    private String url;
}

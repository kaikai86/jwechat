package cn.org.jcloud.jwechat.bean.message.send;

import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import cn.org.jcloud.jwechat.util.xml.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title OutNewsMessage
 * @Description 微信-消息回复-图文消息
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
@NoArgsConstructor
public class OutNewsMessage extends OutBaseMessage {

    /**
     * 必填 是 图文消息个数； 当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息； 其余场景最多可回复8条图文消息
     */
    @XmlElement(name = "ArticleCount")
    private Integer articleCount;

    /**
     * 必填 是 图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     */
    @XmlElement(name = "Articles")
    private Articles articles;


    public OutNewsMessage(MsgTypeEnum msgType, String toUserName, String fromUserName, List<Article> articles) {
        super(msgType, toUserName, fromUserName);
        this.articles = new Articles();
        this.articles.articlesList = articles;
        if (articles != null) {
            this.articleCount = articles.size();
        } else {
            this.articleCount = 0;
        }
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Articles {
        @XmlElement(name = "item")
        private List<Article> articlesList = new LinkedList<Article>();
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Article {
        /**
         * 必填 是 图文消息标题
         */
        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String title;

        /**
         * 必填 是 图文消息描述
         */
        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String description;

        /**
         * 必填 是 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
         */
        @XmlElement(name = "PicUrl")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String picUrl;

        /**
         * 必填 是 点击图文消息跳转链接
         */
        @XmlElement(name = "Url")
        @XmlJavaTypeAdapter(value= CDataAdapter.class)
        private String url;

    }
}

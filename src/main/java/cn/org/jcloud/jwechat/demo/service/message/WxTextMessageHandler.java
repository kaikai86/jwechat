package cn.org.jcloud.jwechat.demo.service.message;

import cn.hutool.json.JSONUtil;
import cn.org.jcloud.jwechat.bean.message.dto.VideoDTO;
import cn.org.jcloud.jwechat.bean.message.receive.InTextMessage;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.handler.message.AbstractWxTextMessageHandler;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title WxTextMessageHandler
 * @Description 微信文本消息处理实现
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxTextMessageHandler extends AbstractWxTextMessageHandler {


    @Override
    protected OutBaseMessage handleDetail(InTextMessage textMessage, String openId, String content, OutMessageHelper outMessageHelper, WxConfig wxConfig) {
//        return outMessageHelper.replyTextMessage(content);
//        return outMessageHelper.replyImageMessage("111");
//        return outMessageHelper.replyImageMessage(ImageDTO.builder().mediaId("111111").build());
//        return outMessageHelper.replyNullMessage();
//        LinkedList<ArticleDTO> objects = new LinkedList<>();
//        ArticleDTO articleDTO = new ArticleDTO();
//        articleDTO.setUrl("http://www.baidu.com");
//        articleDTO.setDescription("dddd");
//        articleDTO.setPicUrl("http://tupian.baidu.com");
//        articleDTO.setTitle("文章图片信息");
//        objects.add(articleDTO);
//        articleDTO = new ArticleDTO();
//        articleDTO.setUrl("http://www.baidu.com1");
//        articleDTO.setDescription("dddd1");
//        articleDTO.setPicUrl("http://tupian.baidu.com1");
//        articleDTO.setTitle("文章图片信息1");
//        objects.add(articleDTO);
//        return outMessageHelper.replyNewsMessage(objects);
        System.err.println(JSONUtil.toJsonStr(wxConfig));
        return outMessageHelper.replyVideoMessage(VideoDTO.builder().mediaId("2222").build());
    }
}

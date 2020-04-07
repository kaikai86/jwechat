package org.jcloud.jwechat;

import org.jcloud.jwechat.api.message.WxMainService;
import org.jcloud.jwechat.config.ApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * @Title WxHandlerScanTest
 * @Description 微信处理扫描器测试类
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxHandlerScanTest {

    private String textXmlInfo;
    private String imgXmlInfo;
    private String subscribeXmlInfo;
    private String miXmlInfo;

    @Before
    public void beforeTest() {
        textXmlInfo = "<xml>\n" +
                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "  <CreateTime>1348831860</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[this is a test]]></Content>\n" +
                "  <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";
        imgXmlInfo = "<xml>\n" +
                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "  <CreateTime>1348831860</CreateTime>\n" +
                "  <MsgType><![CDATA[image]]></MsgType>\n" +
                "  <PicUrl><![CDATA[this is a url]]></PicUrl>\n" +
                "  <MediaId><![CDATA[media_id]]></MediaId>\n" +
                "  <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";
        subscribeXmlInfo = "<xml><ToUserName><![CDATA[gh_fb02d7095dd1]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oeKYfv5gXoKdIxslsgU-1u5eTbfI]]></FromUserName>\n" +
                "<CreateTime>1585889634</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[subscribe]]></Event>\n" +
                "<EventKey><![CDATA[]]></EventKey>\n" +
                "</xml>\n";
        miXmlInfo =  "<xml>\n" +
                "    <ToUserName><![CDATA[gh_fb02d7095dd1]]></ToUserName>\n" +
                "    <Encrypt><![CDATA[QD0GWdyfvsNikvISduZJiZfXkApuTsGCuf99TDWmSoV9Wpwy2bK5cDZoGK1qxAGKy0n21KdBNTWVX9toalsZWaq8pLQ6aj3YO6vNMNob9CTbRTXbR/zY9DnyW+ZEoDSU7RK8q+AxbDT2K9HYf9lUYIEbHmIOL42Y/MaAo3+Jv0psPy+8MLdCyrRu6v0rAJt5fDB1Mi2TV2LqEgYjWL+uPNXqu8Rkhs/MEXh98YzexDqflman4dOISCuKGTuJvNYOMzDbafpCgb/wZCXfUMaHVz7QmEZbpaUZgPclliZtgX1zM61giR3e+dLXZ1jqpGf8jbp2t/53FRuTN3tDo8GRREV3vax99qgH5WHBeXalR3sOvWV/vdeY48i/Erg7CxdzOhRSYoYEcxT1RsKFy5svALZM9OBo7e8Dznvl7Wkj5PLDjqAABowlmzF103piBIr/5uyvuVi7ZBjvqqpzAu1rfA==]]></Encrypt>\n" +
                "</xml>\n";;
    }

    @Test
    public void CustomAPITest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println("Spring 容器启动了。。。");
        String beanNames[]= context.getBeanDefinitionNames();
        for(String beanName:beanNames){
            System.out.println(beanName);
        }
        WxMainService wxBaseService = (WxMainService) context.getBean("wxMainService");
//        String s = wxBaseService.handle(subscribeXmlInfo);
        String s = wxBaseService.handle("aes",miXmlInfo,"1585891674","1448318099","50cf8ecc27afe59417eebf775c44780adb8e8f2e");
        System.err.println(s);

    }

    public static void main(String[] args) {

        String s = String.valueOf(System.currentTimeMillis() / 1000);
        System.err.println(s);
    }
}

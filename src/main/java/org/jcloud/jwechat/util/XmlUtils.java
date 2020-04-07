package org.jcloud.jwechat.util;

import cn.hutool.core.util.XmlUtil;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPathConstants;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @Title XmlUtils
 * @Description XML文本处理工具
 * @Author ZhangKai
 * @Date 2020/3/27 0027 15:33
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class XmlUtils {

    public static void main(String[] args) {
        String xml = "<xml>\n" +
                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "  <CreateTime>1348831860</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[this is a test]]></Content>\n" +
                "  <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";
        Document document = XmlUtil.parseXml(xml);
        Object value = XmlUtil.getByXPath("//xml/MsgType", document, XPathConstants.STRING);
        System.err.println(value);

    }

    public static String convertToXml(Object obj) {
        return convertToXml(obj, "UTF-8");
    }

    public static String convertToXml(Object obj, String encoding) {
        if (obj == null) {
            return "";
        }
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
            marshaller.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler", new CharacterEscapeHandler() {
                @Override
                public void escape(char[] chars, int start, int length, boolean b, Writer writer) throws IOException {
                    writer.write(chars, start, length);
                }
            });
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> T xmlToBean(Class<T> obj, String xmlStr) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(new StringReader(xmlStr));
            return t;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

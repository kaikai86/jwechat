package cn.org.jcloud.jwechat.util.xml;

import javax.xml.stream.XMLStreamWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title CDataHandler
 * @Description 动态代理处理xml
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class CDataHandler implements InvocationHandler {

    private static Method gWriteCharactersMethod = null;
    static {
        try {
            gWriteCharactersMethod = XMLStreamWriter.class
                    .getDeclaredMethod("writeCharacters", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private XMLStreamWriter writer;

    public CDataHandler(XMLStreamWriter writer) {
        this.writer = writer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ( gWriteCharactersMethod.equals(method) ) {
            String text = (String)args[0];
            if ( text != null && text.startsWith("<![CDATA[") && text.endsWith("]]>") ) {
                writer.writeCData(text.substring(9, text.length() - 3));
                return null;
            }
        }
        return method.invoke(writer, args);
    }
}

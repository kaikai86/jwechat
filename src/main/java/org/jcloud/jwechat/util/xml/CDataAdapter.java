package org.jcloud.jwechat.util.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @Title CDataAdapter
 * @Description CData适配类
 * @Author ZhangKai
 * @Date 2020/3/31 0031
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class CDataAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String v) throws Exception {
        return null;
    }

    @Override
    public String marshal(String v) throws Exception {
        return new StringBuilder("<![CDATA[").append(v).append("]]>").toString();
    }
}

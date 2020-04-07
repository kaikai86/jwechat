package cn.org.jcloud.jwechat.util;

import cn.org.jcloud.jwechat.util.encrypt.AesException;
import lombok.extern.apachecommons.CommonsLog;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.util.encrypt.WXBizMsgCrypt;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@CommonsLog
public class MsgEncryptUtil {

	private static final String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

	public static String encrypt(String msg, String timestamp, String nonce, WxConfig wc) {
		try {
			WXBizMsgCrypt pc = new WXBizMsgCrypt(wc.getToken(), wc.getEncodingaeskey(), wc.getAppid());
			return pc.encryptMsg(msg, timestamp, nonce);
		} catch (AesException e) {
			log.error("weixin encrypt msg err :", e);
			throw new RuntimeException(e);
		}
	}

	public static String decrypt(String ciphertext, String timestamp, String nonce, String msgSignature, WxConfig wc) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(ciphertext);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			String encrypt = nodelist1.item(0).getTextContent();
			String fromXML = String.format(format, encrypt);

			String encodingAesKey = wc.getEncodingaeskey();
			if (encodingAesKey == null) {
				log.error("encodingAesKey can not be null !!!");
				throw new IllegalStateException("encodingAesKey can not be null !!!");
			}
			WXBizMsgCrypt pc = new WXBizMsgCrypt(wc.getToken(), encodingAesKey, wc.getAppid());
			return pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		} catch (Exception e) {
			log.error("weixin decrypt msg err :", e);
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String xml = "<xml>\n" +
				"    <ToUserName><![CDATA[gh_fb02d7095dd1]]></ToUserName>\n" +
				"    <FromUserName><![CDATA[oeKYfvxkIfJ1e1aVyJmrql74kE1c]]></FromUserName>\n" +
				"    <CreateTime>1585886316</CreateTime>\n" +
				"    <MsgType><![CDATA[text]]></MsgType>\n" +
				"    <Content><![CDATA[我爱华百德]]></Content>\n" +
				"    <MsgId>22704432612005430</MsgId>\n" +
				"    <Encrypt><![CDATA[Dv4YOCQAMYB3U9K++ZMOtcLdhnbX6IpNfaaXWCsPwlvn9LlaxNF5jL4F+1dt2OUsKHTlMi+RKYu/4qvnJ03TYlZ/c/zTRbMxCD0m/rkhm5u4RQfOKxUyffdUuPzyMkoaPBI2nop5O3c9wK7HCgkobGIaD2z30vBERJA/egbo3wsAtwDBLFxHSyAcj7fQC49Iu1PPPA+Bo4cAG0rqJE+py5RuAoT6a4mEtV/uQ48jgsk/uVJmJUhpWOkxzy846MQbV6WSPxc+9Ll7yR7ESwx1OfcQr0xubjY3WWslwCoem9rWYSa/vShSRICTRmSFyxnuKXBdgwDl8cwacIagCQL10DmAnAY2pa8wRDB4lqRgvJsl6MWZDrVj98I3KfFu6KjBU5mhuLXRq+Q0flYZOr+VaJp1B66f7V4vdw8cFToVjUokuKjY3ByB8DXWXQXoNCXPoE93DDs3qrE+2HST/DpfCQ==]]></Encrypt>\n" +
				"</xml>\n";
		WxConfig config = new WxConfig("wx5d57f2472e4236f1","bd19ee0342c53bb05a8adfcc5152cae5","vtS3YUxauSP3ZovKj46Hj61tqDFjtQmHSIujRMOoJw0","huabaide666888");
		String decrypt = MsgEncryptUtil.decrypt(xml, "1585886316", "410270081", "7554763816c2b409b6bdf21b2f76cd1a279bc7fb", config);
		System.err.println(decrypt);
	}
}

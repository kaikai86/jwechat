package org.jcloud.jwechat.util;

import lombok.extern.apachecommons.CommonsLog;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@CommonsLog
public class SignUtil {
	private static final char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * 校验signature
	 * @param token
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
		if (isBlank(token, signature, timestamp, nonce)) {
			return false;
		} else {
			String[] arr = new String[] { token, timestamp, nonce };
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for (String anArr : arr) {
				sb.append(anArr);
			}
			MessageDigest md;
			String tmpStr = null;

			try {
				md = MessageDigest.getInstance("SHA-1");
				byte[] digest = md.digest(sb.toString().getBytes("UTF-8"));
				tmpStr = byteToStr(digest);
			} catch (NoSuchAlgorithmException e) {
				log.error("加密方式异常", e);
			} catch (UnsupportedEncodingException e) {
				log.error("编码格式不支持", e);
			}
			return tmpStr != null && tmpStr.equalsIgnoreCase(signature);
		}
	}

	public static boolean isNull(String str) {
		return null == str || "".equals(str.trim());
	}

	public static boolean isBlank(String... strs) {
		if (null == strs || 0 == strs.length) {
			return true;
		} else {
			for (String str : strs) {
				if (isNull(str)) {
					return true;
				}
			}
		}
		return false;
	}

	private static String byteToStr(byte[] byteArray) {
		int len = byteArray.length;
		StringBuilder strDigest = new StringBuilder(len * 2);
		for (byte aByteArray : byteArray) {
			strDigest.append(byteToHexStr(aByteArray));
		}
		return strDigest.toString();
	}

	private static String byteToHexStr(byte mByte) {
		char[] tempArr = new char[2];
		tempArr[0] = digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = digit[mByte & 0X0F];
		return new String(tempArr);
	}
}

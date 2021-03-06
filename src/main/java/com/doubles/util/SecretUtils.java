package com.doubles.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

public class SecretUtils {
	private static final Logger LOGGER = Logger.getLogger(SecretUtils.class);
	/**
	 * Md5编码
	 * 
	 * @param src
	 *            明文
	 * @return 密文
	 * @throws UnsupportedEncodingException 
	 */
	static public String md5(String src) throws UnsupportedEncodingException {

		String value = DigestUtils.md5DigestAsHex(src.getBytes("utf-8"));
		return value.toLowerCase();
	}

	/**
	 * 产生24为的随机密码
	 * 
	 * @param len
	 *            密码的长度
	 * @return 24位的密码
	 */
	static public String generateSecret(int len) {
		int random = createRandomInt();
		return generatePassWord(random, len);
	}

	static private String generatePassWord(int random, int len) {
		Random rd = new Random(random);
		final int maxNum = 62;
		StringBuffer sb = new StringBuffer();
		int rdGet;// 取得随机数
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9' };

		int count = 0;
		while (count < len) {
			rdGet = Math.abs(rd.nextInt(maxNum));// 生成的数最大为62-1
			if (rdGet >= 0 && rdGet < str.length) {
				sb.append(str[rdGet]);
				count++;
			}
		}
		return sb.toString();
	}

	/**
	 * 生成一个随机数
	 * 
	 * @return
	 */
	static private int createRandomInt() {
		// 得到0.0到1.0之间的数字，并扩大100000倍
		double temp = Math.random() * 100000;
		// 如果数据等于100000，则减少1
		if (temp >= 100000) {
			temp = 99999;
		}
		int tempint = (int) Math.ceil(temp);
		return tempint;
	}

	/**
	 * 产生32位的uuid
	 * 
	 * @return uuid
	 */
	static public String uuid32() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 比对两个签名是否一致
	 * 
	 * @param src
	 * @param sign
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	static public boolean checkSignature(String src, String sign) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		return md5(src).compareToIgnoreCase(sign) == 0;
	}

	/**
	 * 检查时间戳是否过期
	 * 
	 * @param timestamp
	 * @param expiredtime
	 * @return
	 * @throws ParseException
	 */
	static public boolean checkTimestampExpired(String timestamp, int expiredtime) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentDate = new Date();
		if (expiredtime < 0)
			expiredtime = 0;
		expiredtime = expiredtime*1000;
		Date date = simpleDateFormat.parse(timestamp);
		//System.out.println(date.getTime()+":"+currentDate.getTime());
		if ((date.getTime() - expiredtime) <= currentDate.getTime()
				&& (currentDate.getTime() <= (date.getTime() + expiredtime))) {
			return true;
		}
		return false;
	}
	/**
	 * base64编码
	 * @param src
	 * @return
	 */
	static public String base64Encode(String src){
		
		return Base64Utils.encodeToString(src.getBytes());
	}
	static public String base64Encode(byte[] src){
		
		return Base64Utils.encodeToString(src);
	}
	/**
	 * base64解码
	 * @param src
	 * @return
	 */
	static public String base64Decode(String src){
		try {
			return new String(Base64Utils.decodeFromString(src));
		} catch (Exception e) {
			// TODO: handle exception
		
			LOGGER.error(Utils.throwAbleToString(e));
		}
		return null;
		
	}
	
	static public byte[] base64DecodeByte(String src){
		try {
			return Base64Utils.decodeFromString(src);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(Utils.throwAbleToString(e));
		}
		return null;
		
	}
	
}

package com.doubles.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	static private ObjectMapper objectMapper = new ObjectMapper();

	private static final Logger LOGGER = Logger.getLogger(Utils.class);

	/**
	 * 读取json的值
	 * 
	 * @param key
	 * @param valueType
	 * @return
	 */
	static public <T> T readValue(String key, Class<T> valueType) {
		try {
			return objectMapper.readValue(key, valueType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error(Utils.throwAbleToString(e));
		}

		return null;
	}

	/**
	 * 把对象转为json
	 * 
	 * @param object
	 * @return
	 */
	static public String toJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace().toString());

		}
		return null;
	}

	/**
	 * 产生一个时间戳yyyyMMddHHmmssSSS
	 * 
	 * @return
	 */
	static public String yyyyMMddHHmmss() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String reqId = simpleDateFormat.format(new Date());
		return reqId;
	}

	static public String throwAbleToString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}


}

package com.doubles.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Utils {

	static private ObjectMapper objectMapper = new ObjectMapper();

	private static final Logger LOGGER = Logger.getLogger(Utils.class);

	//返回一个文本中第一个img标签
	static public String getOneImgTag(String content){
		String regex = "<img[^<>]*?\\ssrc=['\"]?(.*?)['\"].*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		if(matcher.find()){
			return matcher.group();
		}else{
			return null;
		}
	}

	//返回一个文本中所有的img标签
	static public List<String> getImgTagList(String content){
		List<String> list = new ArrayList<>();
		String regex = "<img[^<>]*?\\ssrc=['\"]?(.*?)['\"].*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		while (matcher.find()){
			list.add(matcher.group());
		}
		return list;
	}
	//返回一个img标签中的src的内容
	static public String getOneImgSrc(String content){
		String regex = "src\\s*=\\s*\"?(.*?)(\"|>|\\s+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		if(matcher.find()){
			return matcher.group();
		}else{
			return null;
		}
	}


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
//		try {
//			return objectMapper.writeValueAsString(object);
//		} catch (JsonProcessingException e) {
//
//			e.printStackTrace();
//			LOGGER.error(e.getMessage());
//			LOGGER.error(e.getStackTrace().toString());
//
//		}
		return JSON.toJSONString(object);
		//return null;
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

package com.doubles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan("com.doubles.controller")
public class SpringmvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//将所有/static/** 访问都映射到classpath:/static/ 目录下
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

	@Bean
	public ConversionServiceFactoryBean conversionServiceFactoryBean(){
		ConversionServiceFactoryBean conversionServiceFactoryBean=new ConversionServiceFactoryBean();
		Set<Converter> converters=new HashSet<Converter>();
		converters.add(new DateConverterConfig());//日期转换器
		conversionServiceFactoryBean.setConverters(converters);
		return conversionServiceFactoryBean;
	}
}

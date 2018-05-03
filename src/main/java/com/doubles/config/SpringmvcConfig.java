package com.doubles.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan("com.doubles.controller")
public class SpringmvcConfig implements WebMvcConfigurer {

	@Autowired
	RequestMappingHandlerAdapter handlerAdapter;

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

	@PostConstruct
	public void initEditableValidation(){
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
		if (initializer.getConversionService() != null){
			GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();
			genericConversionService.addConverter(new DateConverterConfig());
		}
	}
}

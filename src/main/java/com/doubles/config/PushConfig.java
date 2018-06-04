package com.doubles.config;

import com.doubles.util.ArticlePush;
import com.doubles.util.MessagePush;
import com.doubles.util.TopicPush;
import com.doubles.util.TransmitPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @时间: 2018/4/28
 * @描述：
 */
@Configuration
public class PushConfig {
    @Bean
    public ArticlePush articlePush(){
        return new ArticlePush();
    }

    @Bean
    public MessagePush messagePush(){
        return new MessagePush();
    }

    @Bean
    public TopicPush topicPush(){
        return new TopicPush();
    }

    @Bean
    public TransmitPush transmitPush(){
        return new TransmitPush();
    }
}

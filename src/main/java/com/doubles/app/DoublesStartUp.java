package com.doubles.app;

import com.doubles.util.ArticlePush;
import com.doubles.util.Logger;
import com.doubles.util.MessagePush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @时间: 2018/4/28
 * @描述：实现的CommandLineRunner的类可以在springBoot程序一开始启动的时候就自动执行其run方法，可以用于初始化数据
 */
@Component
public class DoublesStartUp implements CommandLineRunner {
    private static final Logger LOGGER = Logger.getLogger(DoublesStartUp.class);
    @Autowired
    MessagePush messagePush;
    @Autowired
    ArticlePush articlePush;
    @Override
    public void run(String... args) throws Exception {
        //在线程池中开启10个线程,用于推送公告，动态，文章等消息
        LOGGER.info("初始化推送线程");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.execute(messagePush);
        fixedThreadPool.execute(articlePush);
    }
}

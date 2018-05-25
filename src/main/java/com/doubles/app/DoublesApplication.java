package com.doubles.app;

import com.doubles.util.QiniuUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan("com.doubles.config")
@ComponentScan("com.doubles")
@MapperScan("com.doubles.dao")
public class DoublesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoublesApplication.class, args);

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        t1.run();
    }



}

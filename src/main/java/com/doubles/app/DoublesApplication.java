package com.doubles.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.doubles")
@MapperScan("com.doubles.dao")
@Controller
public class DoublesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoublesApplication.class, args);
    }

    @RequestMapping("/index")
    public String index(){
        return "index1";
    }
}

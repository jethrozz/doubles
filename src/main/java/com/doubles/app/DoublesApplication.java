package com.doubles.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.doubles")
@MapperScan("com.doubles.dao")
public class DoublesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoublesApplication.class, args);
    }
}

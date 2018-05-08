package com.doubles.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView index(){

        ModelAndView view = new ModelAndView("/index1");
        view.addObject("h",11);
        return view;
    }
}

package com.wu.kefubbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.wu.kefubbs.mapper")
@SpringBootApplication
public class KefubbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KefubbsApplication.class, args);
    }

}

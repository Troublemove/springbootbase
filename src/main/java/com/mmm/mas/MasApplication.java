package com.mmm.mas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mmm.mas.dao")
public class MasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasApplication.class, args);
    }

}

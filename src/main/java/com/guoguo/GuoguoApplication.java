package com.guoguo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.guoguo.project.*.*.mapper")
public class GuoguoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuoguoApplication.class, args);
    }
}

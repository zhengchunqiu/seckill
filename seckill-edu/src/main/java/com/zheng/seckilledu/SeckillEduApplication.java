package com.zheng.seckilledu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zheng.seckilledu.mapper")
public class SeckillEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillEduApplication.class, args);
    }

}

package com.bingoastradirectwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;

@RefreshScope
@SpringBootApplication
@EnableCaching
@EnableScheduling

public class BingoAstraDirectWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BingoAstraDirectWebServiceApplication.class, args);
    }

}

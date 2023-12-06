package com.italycalibur.mall.tiny.jpa.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.italycalibur.mall.tiny.jpa"})
public class MallTinyJpaCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallTinyJpaCoreApplication.class, args);
        System.out.println("SpringBoot，启动！Ciallo～(∠・ω< )⌒★");
    }

}

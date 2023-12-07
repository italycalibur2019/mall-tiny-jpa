package com.italycalibur.mall.tiny.jpa.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.italycalibur.mall.tiny.jpa.entity.modules.*.repository")
@EntityScan(basePackages = "com.italycalibur.mall.tiny.jpa.entity.modules.*.model")
@SpringBootApplication(scanBasePackages = {"com.italycalibur.mall.tiny.jpa"})
public class MallTinyJpaCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallTinyJpaCoreApplication.class, args);
        System.out.println("SpringBoot，启动！Ciallo～(∠・ω< )⌒★");
    }

}

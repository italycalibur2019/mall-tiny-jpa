package com.italycalibur.mall.tiny.jpa.common;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc基本配置
 * @author italycalibur
 * @since 2023/12/6
 */
@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI mallTinyJPAOpenAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(apiExternalDocumentation());
    }

    private Info apiInfo() {
        return new Info()
                .title("mall-tiny-jpa API")
                .description("基于macro的项目脚手架mall-tiny，使用postgresql、spring data jpa和querydsl等技术编写")
                .contact(apiContact())
                .license(apiLicense())
                .version("v1.0.0");
    }

    private Contact apiContact() {
        return new Contact()
                .name("italycalibur")
                .url("https://italycalibur.top/")
                .email("920893925@qq.com");
    }

    private License apiLicense() {
        return new License()
                .name("MIT")
                .url("https://opensource.org/licenses/MIT");
    }

    private ExternalDocumentation apiExternalDocumentation() {
        return new ExternalDocumentation()
                .description("项目仓库地址")
                .url("https://github.com/italycalibur2019/mall-tiny-jpa");
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.italycalibur.mall.tiny.jpa.core.modules")
                .build();
    }
}

package com.yjyq.user.initdata;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** Swagger api 配置类
 * @author sunxingba
 * @version 1.0 $
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                // "/sw/user2/users" 路径中多了/sw/
//                .pathMapping("/sw")
                .pathMapping("/")
                .select()
                // 指定api所在包(包下的所有controller 都会被显示为api)
                .apis(RequestHandlerSelectors.basePackage("com.yjyq.user.restapicontroller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                            .title("SpringBoot整合swagger")
                            .description("SpringBoot整合swagger,详情信息...")
                            .version("9.0")
                            .contact(new Contact("用户管理","blog.csdn.net","109@qq.com"))
                            .license("The Apache License").licenseUrl("http://www.baidu.com").build());
    }
}

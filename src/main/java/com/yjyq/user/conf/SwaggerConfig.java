package com.yjyq.user.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** Swagger api 配置类[如果使用了springSecurity,不做改配置会被拦截]
 * @author sunxingba
 * @version 1.0 $
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置映射路径和要扫描的接口的位置，在apiInfo中，
     * 主要配置一下Swagger2文档网站的信息，例如网站的title，网站的描述，联系人的信息，使用的协议等
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                // "/sw/user2/users" 路径中多了/sw/
                //.pathMapping("/sw")
                .pathMapping("/")
                .select()
                // 指定api所在包(包下的所有controller 都会被显示为api)
                .apis(RequestHandlerSelectors.basePackage("com.yjyq.user.rest"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                            .title("SpringBoot整合swagger")
                            .description("SpringBoot整合swagger,详情信息...")
                            .version("9.0")
                            .contact(new Contact("用户管理","blog.csdn.net","109@qq.com"))
                            .license("The Apache License").licenseUrl("http://www.baidu.com").build());
    }


}

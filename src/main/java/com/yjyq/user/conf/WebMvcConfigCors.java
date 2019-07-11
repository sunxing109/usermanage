package com.yjyq.user.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunxingba
 * @version 1.0 $
 */
@Configuration
public class WebMvcConfigCors implements WebMvcConfigurer {

    /*
        /**表示本应用的所有方法都会去处理跨域请求，
        allowedMethods表示允许通过的请求数，
        allowedHeaders则表示允许的请求头。
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8082")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}

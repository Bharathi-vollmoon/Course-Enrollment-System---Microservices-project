package com.example.User_Service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info()
                .title("Course enrollment system API's")
                .description("Api documentation for user service "));

    }

//    @Bean
//    public GroupedOpenApi userAPI(){
//        return GroupedOpenApi.builder()
//                .group("User Service")
//                .pathsToMatch("/users/**")
//                .build();
//    }
}

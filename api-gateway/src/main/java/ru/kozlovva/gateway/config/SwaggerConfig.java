package ru.kozlovva.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("API GATEWAY")
                        .version("v1")
                        .build())
                .groupName("v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.kozlovva"))
                .paths(PathSelectors.any())
                .build();
    }
}

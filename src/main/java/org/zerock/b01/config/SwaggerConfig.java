package org.zerock.b01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false) // 응답코드(200,401,405,404) 기본 메시지 제거해줌
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.zerock.b01.controller")) // 패키지를 문서화
                .paths(PathSelectors.any()) // api 문서를 다시 문서화 한다
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Boot 01 Project Swagger")
                .build();
    }
}

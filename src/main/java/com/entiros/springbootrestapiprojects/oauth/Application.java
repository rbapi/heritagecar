package com.entiros.springbootrestapiprojects.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication(scanBasePackages = {"com.entiros.springbootrestapiprojects"})
@EnableSwagger2
@EnableOAuth2Sso // Without this, basic authentication is invoked
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("heritageCars")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/heritageCar.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("VCC-Heritage-API")
                .description("This API contains the list of Heritage Cars from the Volvo Cars Corpoartion Company !")
                .contact("Entiros Integrations")
                .licenseUrl("www.entiros.se")
                .version("1.0")
                .build();
    }
}
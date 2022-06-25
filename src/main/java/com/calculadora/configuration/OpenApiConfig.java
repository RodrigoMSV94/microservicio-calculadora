package com.calculadora.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	@Bean
    public static OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio con Spring boot")
                        .description("Calculadora API")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Rodrigo Serrano")
                                .url("https://www.linkedin.com/in/devrodrigomsv/")
                                .email("rodrigo.serrano.vega@outlook.es"))
                );
    }
}

package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // Define Basic Authentication scheme
        SecurityScheme basicAuthScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("basic");

        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes("basicAuth", basicAuthScheme)
                )
                .addSecurityItem(
                        new SecurityRequirement().addList("basicAuth")
                )
                .servers(List.of(
                        new Server().url("https://9269.pro604cr.amypo.ai/")
                ));
    }
}

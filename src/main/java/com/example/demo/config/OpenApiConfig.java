package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "BearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
            // API info
            .info(new Info()
                .title("Maintenance Ticket Root-Cause Categorizer API")
                .version("1.0")
                .description("API for tickets, categories, rules, urgency policies, and categorization engine")
            )

            // Server URL
            .servers(List.of(
                new Server().url("https://9249.408procr.amypo.ai")
            ))

            // 🔐 Apply JWT globally
            .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))

            // 🔐 Define Bearer JWT scheme
            .components(new Components()
                .addSecuritySchemes(SECURITY_SCHEME_NAME,
                    new SecurityScheme()
                        .name(SECURITY_SCHEME_NAME)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                )
            );
    }
}
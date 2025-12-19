package org.onlix.catalog.core.openapi.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder()
                .group("Product API")
                .pathsToMatch("/api/products/**")
                .addOpenApiCustomizer(productApiCustomiser())
                .build();
    }

    private OpenApiCustomizer productApiCustomiser() {
        return openApi -> openApi.info(new Info()
                .title("Product API")
                .description("API for managing products")
                .version("1.0"));
    }
}

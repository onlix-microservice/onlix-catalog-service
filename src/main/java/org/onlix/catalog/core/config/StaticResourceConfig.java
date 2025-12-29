package org.onlix.catalog.core.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("dev")
public class StaticResourceConfig implements WebMvcConfigurer {

    @Value("${app.static.img-path}")
    private String staticPath;

    @PostConstruct
    void init() {
        System.out.println("StaticResourceConfig loaded. img-path=" + staticPath);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(staticPath);
    }
}

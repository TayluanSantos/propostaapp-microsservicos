package com.tayluan.propostaapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tudo que vier depois do endereço da origem, tem permissão
                .allowedOrigins("http://localhost/")
                .allowedMethods("*"); // Todos os métodos são permitidos
    }
}

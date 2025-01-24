package com.example.spring_boot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/timer_bar",
                "/app/timer_baz");
        // Incluir todas las rutas dentro de app
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/**");
        // Excluir
        // registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/timer_bar",
        //       "/app/timer_baz");
    }
}

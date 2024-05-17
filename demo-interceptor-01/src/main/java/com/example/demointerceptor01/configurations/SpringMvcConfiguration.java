package com.example.demointerceptor01.configurations;

import com.example.demointerceptor01.interceptors.ApiLoggingInterceptor;
import com.example.demointerceptor01.interceptors.LegacyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMvcConfiguration implements WebMvcConfigurer {

    private final ApiLoggingInterceptor apiLoggingInterceptor;
    private final LegacyInterceptor legacyInterceptor;

    public SpringMvcConfiguration(ApiLoggingInterceptor apiLoggingInterceptor, LegacyInterceptor legacyInterceptor) {
        this.apiLoggingInterceptor = apiLoggingInterceptor;
        this.legacyInterceptor = legacyInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyInterceptor);
    }
}

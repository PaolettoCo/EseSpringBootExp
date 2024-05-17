package com.example.demointerceptor01.month.configuration;

import com.example.demointerceptor01.month.interceptor.MonthInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class InterceptorsConf implements WebMvcConfigurer {

    private final MonthInterceptor monthInterceptor;

    public InterceptorsConf(MonthInterceptor monthInterceptor) {
        this.monthInterceptor = monthInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor);
    }
}

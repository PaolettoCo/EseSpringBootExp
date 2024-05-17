package com.example.demointerceptor01.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().startsWith("/basic")){
            String userAgent = request.getHeader("User-Agent");
            System.out.println("Richiesta in arrivo con User-Agent: " + userAgent);
            return true;
        }
        return true;
    }
}

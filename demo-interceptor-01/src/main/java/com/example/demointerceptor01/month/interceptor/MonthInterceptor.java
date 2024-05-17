package com.example.demointerceptor01.month.interceptor;

import com.example.demointerceptor01.month.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;
@Component
public class MonthInterceptor implements HandlerInterceptor {

    private final PathMatcher pathMatcher = new AntPathMatcher();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!this.pathInclude(request)){
            return true;
        }
        if(this.pathInclude(request) && this.handle(request)){
            return true;
        }
        response.sendError(400, "bad request");
        return false;
    }

    public boolean pathInclude(HttpServletRequest request){
        List<String> pathToInclude = new ArrayList<>();
        pathToInclude.add("/months/**");
        for(String element : pathToInclude){
            if(pathMatcher.match(element, request.getRequestURI())){
                return true;
            }
        }
        return false;
    }

    public boolean handle(HttpServletRequest request){
        List <Month> months  = new ArrayList<>();
        months.add(Month.MonthBuilder.aMonth().withMonthNumber(1).withItalianName("gennaio").build());
        months.add(Month.MonthBuilder.aMonth().withMonthNumber(2).withItalianName("febbraio").build());
        months.add(Month.MonthBuilder.aMonth().withMonthNumber(3).withItalianName("marzo").build());
        months.add(Month.MonthBuilder.aMonth().withMonthNumber(4).withItalianName("aprile").build());
        months.add(Month.MonthBuilder.aMonth().withMonthNumber(5).withItalianName("maggio").build());
        months.add(Month.MonthBuilder.aMonth().withMonthNumber(6).withItalianName("giugno").build());

        int monthN = Integer.parseInt(request.getHeader("monthNumber"));

        for(Month element : months){
            if(element.getMonthNumber().equals(monthN)){
                request.setAttribute("monthNumber", element);
                return true;
            }
        }

        request.setAttribute("monthNumber", Month.MonthBuilder.aMonth().withMonthNumber(0).withItalianName("nope").build());
        return true;

    }
}

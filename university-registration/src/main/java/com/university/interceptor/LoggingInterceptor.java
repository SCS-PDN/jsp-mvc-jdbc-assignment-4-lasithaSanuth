package com.university.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, 
                             HttpServletResponse response, 
                             Object handler) throws Exception {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        System.out.println("[LOG] Request: " + method + " " + uri);

        if (uri.contains("/login") && method.equals("POST")) {
            String email = request.getParameter("email");
            System.out.println("[LOG] Login attempt by: " + email);
        }

        if (uri.contains("/register")) {
            System.out.println("[LOG] Course registration attempt on: " + uri);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("[LOG] Response status: " + response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, 
                                HttpServletResponse response, 
                                Object handler, Exception ex) throws Exception {
        if (ex != null) {
            System.out.println("[LOG] Exception: " + ex.getMessage());
        }
    }
}
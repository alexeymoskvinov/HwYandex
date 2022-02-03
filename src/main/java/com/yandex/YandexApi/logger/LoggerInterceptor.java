package com.yandex.YandexApi.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    private long startTime = 0;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        log.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "][" + response + "]");

        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {

        long endTime = System.currentTimeMillis();
        log.info("[postHandle][" + request.getRequestURI() + "]" + "[" + request.getMethod() + "]" + "[" + response +
                "][Executing time: " + (endTime - startTime) + " ms]");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (ex != null){
            ex.printStackTrace();
        }
        log.info("[afterCompletion][" + request + "]" + "[" + request.getMethod() + "][" + response + "][" + ex + "]");
    }
}

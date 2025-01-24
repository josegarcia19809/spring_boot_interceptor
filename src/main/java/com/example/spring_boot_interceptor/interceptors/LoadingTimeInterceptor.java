package com.example.spring_boot_interceptor.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(
            LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("LoadingTimeInterceptor: preHandle. Entrando..." +
                handlerMethod.getMethod().getName());

        // Recuperar tiempo inicial
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        // Simulamos un retardo
        Random random = new Random();
        int delay = random.nextInt(1000);
        Thread.sleep(delay);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");
        long duration = endTime - startTime;
        logger.info("Tiempo transcurrido: " + duration + " milisegundos");

        logger.info("LoadingTimeInterceptor: postHandle. Saliendo..." +
                ((HandlerMethod) handler).getMethod().getName());
    }
}

package com.asi.security.saml.web.controllers;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by skaki on 9/27/17.
 */
@Component
public class MultiTenantController extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        System.out.println("In preHandle we are Intercepting the Request");
        System.out.println("____________________________________________");
        String requestURI = request.getRequestURI();
        String p = ServletRequestUtils.getStringParameter(request, "p", "No P");
        System.out.println("RequestURI::" + requestURI +
                " || Tenant Key ::" + p);
        System.out.println("____________________________________________");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView model)
            throws Exception {
        System.out.println("_________________________________________");
        System.out.println("In postHandle request processing "
                + "completed by @RestController");
        System.out.println("_________________________________________");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception arg3)
            throws Exception {
        System.out.println("________________________________________");
        System.out.println("In afterCompletion Request Completed");
        System.out.println("________________________________________");
    }

}
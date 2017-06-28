package com.senyint.zuul.security.interceptor;

import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-27 上午9:33
 */
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
//        System.out.println("SecurityInterceptor");
//
//        String servletPath = request.getServletPath();
//        if(servletPath.equals("/login") || servletPath.equals("/loginform"))
//            return true;
//
//        HttpSession session = request.getSession();
//
//        Object login = session.getAttribute("login");
//
//        if (login != null && ((boolean) login == true)) {
//            return true;
//        }
//
//        String url = "/loginform";
//        request.getSession().setAttribute("path",request.getServletPath());
//        try {
//            request.getRequestDispatcher(url).forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        response.sendRedirect(url);
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("SecurityInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("SecurityInterceptor afterCompletion");
    }
}

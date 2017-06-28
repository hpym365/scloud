package com.senyint.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-25 下午5:56
 */
@Component
public class PreFilter extends ZuulFilter {

    // filterType: pre 请求之前执行 route路由时执行 post请求后执行
    @Override
    public String filterType() {
        return "pre";
    }

    // 相同type的过滤器执行的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否执行本拦截器
    @Override
    public boolean shouldFilter() {
        return true;
    }


    // 具体执行的方法
    @Override
    public Object run() {
        System.out.println("preFilter run");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpServletResponse response = currentContext.getResponse();
        if (request.getSession().getAttribute("login") == null) {
            String loginurl = "/loginform";
            try {
//                String path = request.getServletPath();
//                if(!path.startsWith("/login"))
//                    request.setAttribute("path",request.getServletPath());

                request.getRequestDispatcher(loginurl).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//                currentContext.getResponse().sendRedirect("/loginform");
        }
//        System.out.println("pre");
//        RequestContext currentContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = currentContext.getRequest();
//        Cookie[] cookies = request.getCookies();
//        String servletPath = request.getServletPath();
//
//        String token = request.getParameter("token");
//        if (token == null) {
//            currentContext.setSendZuulResponse(false);
//            currentContext.setResponseStatusCode(401);
//            currentContext.setResponseBody("没有权限无法访问");
//            HttpServletResponse response = currentContext.getResponse();
//
//            try {
//                response.setHeader("Content-type", "text/html;charset=UTF-8");
//                response.getWriter().write("没有权限无法访问");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return "没有权限无法访问";
//        }
        return null;
    }
}

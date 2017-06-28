package com.senyint.zuul.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-26 下午3:47
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response,
                        ModelMap map,
                        @RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password) throws ServletException, IOException {

//        request.getSession()
        if(1==1 || (username!=null && password!=null) && username.equals("test") && password.equals("test")){
            request.getSession().setAttribute("login",true);
            map.put("msg","登录成功");
            map.put("login",true);
        }else {
            map.put("msg","用户名密码错误");
            map.put("login",false);
        }

        String  path = (String) request.getAttribute("path");
        System.out.println(path);
        map.put("path",path);
        return "loginhtml";
    }


    @RequestMapping("/loginform")
    public String loginform(HttpServletRequest request, HttpServletResponse response, ModelMap map, @RequestParam(value = "user", required = false) String user, @RequestParam(value = "pass", required = false) String pass) throws ServletException, IOException {
        return "ffff";
    }

    @RequestMapping("/test")
    public String test() {

        return "test";
    }
}

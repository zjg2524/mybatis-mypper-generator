package com.jmeter.demo;

import com.jmeter.demo.interceptor.LoginInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MapperScan(basePackages = "com.jmeter.demo.dao")
@SpringBootApplication
@RestController
public class JmeterdemoApplication extends WebMvcConfigurationSupport {
    @Autowired
    LoginInterceptor loginInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(JmeterdemoApplication.class, args);
    }


    @RequestMapping("/")
    public String home() {
        return "spring boot security demo home.....";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello....";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        Object user = request.getSession().getAttribute("user");
        if(user!=null){
            return "已经登录。。。。。。。。。。。";
        }
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(pwd)){
            return "账号 或者 密码格式不正确......";
        }
        System.out.println("username -> "+userName+" pwd -> "+pwd);
        HttpSession session = request.getSession();
        session.setAttribute("user","username -> "+userName+" pwd -> "+pwd);

        Cookie cookie = new Cookie("loginCookie",userName);
        cookie.setMaxAge(1000*60*30);
        cookie.setPath("/jemeter");
        response.addCookie(cookie);

        return "login success ............";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return "logout ..............";
    }
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)//.addPathPatterns("/**")
//                .excludePathPatterns("/login/**")
//                .excludePathPatterns("/**")
//                .excludePathPatterns("/logout/**");
//    }
}

package com.lj.test.demo.controller;

import com.lj.test.demo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @RequestMapping(value={"/","/home"})
    public String home(){
        return "home";
    }

    @PreAuthorize("hasRole('ROLE_USER')")       //注解支持使用SpEL表达式
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/403")
    public String forbidden(){
        return "error/403";
    }
}

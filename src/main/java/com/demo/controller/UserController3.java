package com.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
@Controller
@RequestMapping("/user")
public class UserController3 {
    @RequestMapping(value = "/test.html")
    public String test(Model model) {
        //model.addAttribute("name", "Dear");
        return "test";//上面两行的test和返回的"test"，就是对应的thymeleaf的html页面名字，
        //在这个工程里面就是  resources/templates/test.html，这样就可以实现映射
    }
}

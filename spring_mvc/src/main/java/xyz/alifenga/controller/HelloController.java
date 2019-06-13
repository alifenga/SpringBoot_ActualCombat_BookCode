package xyz.alifenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 简单控制器
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        System.out.println("进来了");
        return "index";
    }
}

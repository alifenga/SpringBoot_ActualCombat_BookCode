package xyz.alifenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.alifenga.po.DemoObj;

/**
 * 演示控制器
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("非常抱歉,参数有误,来自@ModelAttribute:" + msg);
    }
}

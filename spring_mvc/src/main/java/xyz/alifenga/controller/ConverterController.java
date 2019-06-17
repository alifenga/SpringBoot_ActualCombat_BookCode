package xyz.alifenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.alifenga.po.DemoObj;

/**
 * HttpMessageConverter控制器
 */
@Controller
public class ConverterController {

    /**
     * 指定媒体类型为我们自定义的媒体类型application/x-wisely
     *
     * @param obj
     * @return
     */
    @RequestMapping(value = "/convert", produces = {"application/x-wisely;charset=UTF-8"})
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj obj) {
        return obj;
    }
}

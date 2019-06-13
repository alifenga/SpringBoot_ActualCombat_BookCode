package xyz.alifenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.alifenga.po.DemoObj;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    /**
     * produces可定制返回的response的媒体类型和字符集
     * 或需返回的是json对象,则设置为produces = "application/json;charset=UTF-8"
     * 演示可接受HttpServletRequest作为参数,也可以接受HttpServletRespone作为参数
     * 此处的@ResponseBody用在返回值前面
     *
     * @return
     */
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String index(HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access";
    }

    /**
     * 演示接受参数路径参数,并在方法参数前结合@PathVariable使用,访问路径为/anno/pathvat/xx
     *
     * @param str
     * @param request
     * @return
     */
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,str:" + str;
    }

    /**
     * 演示常规的request参数获取,访问路径为/anno/requestParam?id=1
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,id:" + id;
    }

    /**
     * 演示解释参数到对象,访问路径为/anno/obj?id=x&name=xx
     * 讲@ResponseBody用在方法上
     *
     * @param obj
     * @param request
     * @return
     */
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,obj id:" + obj.getId() + ",obj name:" + obj.getName();
    }

    /**
     * 演示映射不同的路径到相同的方法,访问路径为/anno/name1或者/anno/name2
     * @param request
     * @return
     */
    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access";
    }
}

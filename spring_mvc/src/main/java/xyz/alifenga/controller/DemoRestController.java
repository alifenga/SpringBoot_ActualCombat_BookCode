package xyz.alifenga.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.alifenga.po.DemoObj;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")
    public DemoObj getJson(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "测试JSON");
    }

    @RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8")
    public DemoObj getXml(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "测试XML");
    }
}

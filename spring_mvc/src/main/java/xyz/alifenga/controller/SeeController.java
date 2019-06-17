package xyz.alifenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * WebSocket演示控制器
 */
@Controller
public class SeeController {

    /**
     * 这里输出的媒体类型为text/event-stream,这里是服务端SSE的支持,本例演示每5秒向浏览器推送随机信息
     * @return
     */
    @RequestMapping(value = "/push",produces = "text/event-stream")
    @ResponseBody
    public String push(){
        Random random = new Random();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "data:"+random.nextInt()+"\n";
    }
}

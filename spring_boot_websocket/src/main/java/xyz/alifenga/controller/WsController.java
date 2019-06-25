package xyz.alifenga.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import xyz.alifenga.po.WiselyMessage;
import xyz.alifenga.po.WiselyResponse;

/**
 * 演示控制器
 */
@Controller
public class WsController {

    /**
     * 当浏览器向服务端发送请求时,通过@MessageMapping映射/welcome这个地址,类似于@RequestMapping
     * 当服务有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
     *
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        return new WiselyResponse("Welcome," + message.getName() + "!");
    }
}

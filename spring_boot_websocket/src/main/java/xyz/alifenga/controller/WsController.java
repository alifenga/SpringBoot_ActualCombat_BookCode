package xyz.alifenga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import xyz.alifenga.po.WiselyMessage;
import xyz.alifenga.po.WiselyResponse;

import java.security.Principal;

/**
 * 演示控制器
 */
@Controller
public class WsController {

    /**
     * 注入SimpMessagingTemplate
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

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

    /**
     * 在SpringMVC中,可以直接在参数中获得Principal,Principal中包含当期用户的消息
     * 这里设置了硬编码,如果发送人是admin,则发送给manager,否则反之
     * 通过messagingTemplate.convertAndSendToUser来发送消息,
     * 第一个参数是接收消息的用户,第二个是浏览器订阅的地址,第三个是消息本身
     *
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("admin")) {
            messagingTemplate.convertAndSendToUser("manager", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("admin", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }
    }
}

package xyz.alifenga.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 配置WebSocket,需要在配置类使用@EnableWebSocketMessageBroker开启WebSocket支持,
 * 并通过继承WebSocketMessageBrokerConfigurer类,重写其方法来配置WebSocket(过时)
 * (SpringBoot2.0后使用实现WebSocketMessageBrokerConfigurer来配置)
 *
 * 注解@EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理(message broker)的消息
 * 这时控制器支持使用@MessageMapping,就行使用@RequestMapping一样
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 注册STOMP协议的节点(endpoint),并映射指定的URL
     * 注册一个STOMP的endpoint,并且使用SockJS协议
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS();
    }

    /**
     * 配置消息代理Message Broker
     * 广播式应配置一个/topic消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}

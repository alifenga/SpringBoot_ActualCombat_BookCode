package xyz.alifenga.page44;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher publisher = context.getBean(DemoPublisher.class);

        publisher.publish("你好,世界");

        context.close();
    }
}

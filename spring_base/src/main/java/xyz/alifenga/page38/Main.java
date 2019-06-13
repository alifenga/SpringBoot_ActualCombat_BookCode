package xyz.alifenga.page38;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);

        context.getBean(BeanWayService.class);

        context.getBean(JSR250WayService.class);

        context.close();
    }
}

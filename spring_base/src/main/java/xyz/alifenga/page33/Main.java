package xyz.alifenga.page33;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);

        ElConfig resourceService = context.getBean(ElConfig.class);

        resourceService.outputResource();

        context.close();
    }
}

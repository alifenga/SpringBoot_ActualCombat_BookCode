package xyz.alifenga.page61;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        DemoService service = context.getBean(DemoService.class);

        service.outputResult();

        context.close();
    }
}

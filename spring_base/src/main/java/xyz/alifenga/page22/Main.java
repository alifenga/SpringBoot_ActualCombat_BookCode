package xyz.alifenga.page22;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行测试
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("Java"));
        context.close();
    }
}

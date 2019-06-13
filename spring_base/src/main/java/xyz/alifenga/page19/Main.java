package xyz.alifenga.page19;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行测试
 * 使用AnnotationConfigApplicationContext可以实现基于Java的配置类加载Spring的应用上下文。
 */
public class Main {
    public static void main(String[] args) {
        //创建spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        //从容器中获取Bean
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        //调用方法打印
        System.out.println(useFunctionService.sayHello("Java"));


        //遍历容器中的Bean
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(">>>>>>" + name);
        }
        System.out.println("------Bean 总计:" + context.getBeanDefinitionCount());

        //关闭
        context.close();
    }
}

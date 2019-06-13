package xyz.alifenga.page57;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



/**
 * 测试
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService listService = context.getBean(ListService.class);

        System.out.println(listService.showListCmd());

        context.close();
    }
}

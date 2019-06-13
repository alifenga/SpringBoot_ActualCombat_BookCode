package xyz.alifenga.page41;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //先讲活动的profile设置为prod
        context.getEnvironment().setActiveProfiles("prod");
        //context.getEnvironment().setActiveProfiles("dev");

        //后置注册Bean的配置类,不然会报Bean未定义的错误
        context.register(ProfileConfig.class);

        //刷新容器
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);

        System.out.println(demoBean.getContent());

        context.close();
    }
}

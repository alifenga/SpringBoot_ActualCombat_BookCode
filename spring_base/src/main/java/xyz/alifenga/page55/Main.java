package xyz.alifenga.page55;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

        ScheduleTaskService service = context.getBean(ScheduleTaskService.class);
    }
}

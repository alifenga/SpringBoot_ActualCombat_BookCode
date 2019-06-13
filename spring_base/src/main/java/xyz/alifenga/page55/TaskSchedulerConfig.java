package xyz.alifenga.page55;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 配置类
 */
@Configuration
@ComponentScan("xyz.alifenga.page55")
//@EnableScheduling开启对计划任务的支持
@EnableScheduling
public class TaskSchedulerConfig {
}

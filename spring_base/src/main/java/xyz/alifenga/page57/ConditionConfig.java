package xyz.alifenga.page57;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
public class ConditionConfig {

    @Conditional(WindowsCondition.class)
    @Bean
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public ListService linuxListService(){
        return new LinuxListService();
    }
}

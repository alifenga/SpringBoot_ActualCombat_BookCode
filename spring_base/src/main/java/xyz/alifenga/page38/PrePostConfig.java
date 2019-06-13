package xyz.alifenga.page38;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
@ComponentScan("xyz.alifenga.page38")
public class PrePostConfig {

    //指定int和destroy的方法
    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return  new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}

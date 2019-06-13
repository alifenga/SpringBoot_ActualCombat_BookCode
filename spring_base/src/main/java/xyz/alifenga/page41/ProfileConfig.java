package xyz.alifenga.page41;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profile配置类
 */
@Configuration
public class ProfileConfig {

    @Bean
    //profile为dev是实例化devDemoBean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return  new DemoBean("这是dev的DemoBean");
    }

    @Bean
    @Profile("prod")
    //prod为dev是实例化prodDemoBean
    public DemoBean prodDemoBean(){
        return  new DemoBean("这是prod的DemoBean");
    }
}

package xyz.alifenga.page61;

import org.springframework.stereotype.Service;

/**
 * 演示服务Bean
 */
@Service
public class DemoService {

    public void outputResult(){
        System.out.println("从组合注解配置中获得Bean");
    }
}

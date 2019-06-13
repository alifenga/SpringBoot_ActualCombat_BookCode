package xyz.alifenga.page19;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @Configuration 声明当前类是一个配置类
 * @ComponentScan 自动扫描包名下面所有使用@Service @Component @Repository @Controller的类,并注入为Bean
 */

@Configuration
@ComponentScan("xyz.alifenga.page19")
public class DiConfig {

}

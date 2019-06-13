package xyz.alifenga.page25;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 */
@Configuration
@ComponentScan("xyz.alifenga.page25")
// 开启Spring对AspectJ的支持
@EnableAspectJAutoProxy
public class AopConfig {
}

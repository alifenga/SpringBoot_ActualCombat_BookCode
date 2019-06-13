package xyz.alifenga.page61;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 组合注解与元注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//组合@Configuration元注解
@Configuration
//组合@ComponentScan元注解
@ComponentScan
public @interface WiselyConfiguration {
    /**
     * 覆盖value参数
     * @return
     */
    String[] value() default {};
}

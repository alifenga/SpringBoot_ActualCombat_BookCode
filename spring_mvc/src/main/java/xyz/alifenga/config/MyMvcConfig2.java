package xyz.alifenga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * MVC配置
 *
 * @EnableWebMvc 开启SpringMVC支持
 */
@Configuration
@EnableWebMvc
@ComponentScan("xyz.alifenga")
public class MyMvcConfig2 extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 默认页面配置
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //过滤级别最高
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("/").setViewName("/index");
    }

    /**
     * addResourceLocations 文件放置的目录
     * addResourceHandler 对外暴露的访问路径
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets");
        super.addResourceHandlers(registry);
    }

    /**
     * 重写addInterceptors方法,注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 配置拦截器Bean
     *
     * @return
     */
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }


    /**
     * 不忽略请求路径"."后面的参数
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}

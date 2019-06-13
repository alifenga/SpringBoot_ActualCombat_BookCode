package xyz.alifenga.page38;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean的初始化和销毁
 * 使用JSR250形式的Bean
 */
public class JSR250WayService {
    //在构造函数执行完之后执行
    @PostConstruct
    public void init(){
        System.out.println("JSR250-init-mehtod");
    }

    public JSR250WayService(){
        System.out.println("初始化构造函数-JSR250WayService");
    }

    //在Bean销毁前执行
    @PreDestroy
    public void destory(){
        System.out.println("JSR250-destory-mehtod");
    }
}

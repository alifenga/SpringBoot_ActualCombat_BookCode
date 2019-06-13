package xyz.alifenga.page38;

/**
 * Bean的初始化和销毁
 * 使用@Bean形式的Bean
 */
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}

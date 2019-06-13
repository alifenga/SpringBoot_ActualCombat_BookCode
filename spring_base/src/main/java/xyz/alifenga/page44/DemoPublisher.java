package xyz.alifenga.page44;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 */
@Component
public class DemoPublisher {

    //注入ApplicationContext用来发布事件
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        //使用publishEvent方法来发布DemoEvent事件
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}

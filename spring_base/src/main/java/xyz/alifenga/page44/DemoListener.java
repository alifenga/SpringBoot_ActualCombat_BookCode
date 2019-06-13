package xyz.alifenga.page44;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 */
@Component
//实现ApplicationListener接口,并指定监听的事件类型
public class DemoListener implements ApplicationListener<DemoEvent> {

    //使用onApplicationEvent
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("接收的信息:" + demoEvent.getMsg());
    }
}

package xyz.alifenga.page33;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 编写一个需要属性注入的Bean
 */
@Service
public class DemoService {

    //此处演示的普通字符串注入
    @Value("其他类的属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}

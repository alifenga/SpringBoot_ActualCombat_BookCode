package xyz.alifenga.page31;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 编写Prototype的Bean
 *
 * @Scope("prototype") 每次调用都新建一个Bean的实例
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}

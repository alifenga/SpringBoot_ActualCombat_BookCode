package xyz.alifenga.page19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用功能类的bean
 *
 * @Autowired 依赖注入
 */
@Service
public class UseFunctionService {

    @Autowired
    FunctionService functionService;

    public String sayHello(String string) {
        return functionService.sayHello(string);
    }
}

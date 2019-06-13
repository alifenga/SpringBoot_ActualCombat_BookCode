package xyz.alifenga.page19;

import org.springframework.stereotype.Service;

/**
 * 功能类的bean
 *
 * @Service 注入Bean
 */
@Service
public class FunctionService {

    public String sayHello(String string) {
        return "Hello " + string + "!";
    }
}

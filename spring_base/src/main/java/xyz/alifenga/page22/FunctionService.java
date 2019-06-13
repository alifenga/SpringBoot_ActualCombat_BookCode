package xyz.alifenga.page22;

/**
 * 功能类的bean
 *
 * 不是用@Service等之类注解注入
 */
public class FunctionService {

    public String sayHello(String string) {
        return "Hello " + string + "!";
    }
}

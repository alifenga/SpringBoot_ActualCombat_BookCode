package xyz.alifenga.page22;

/**
 * 使用功能类的Bean
 *
 * 不使用@Service等注解
 * 不采用注解依赖注入,使用set方法
 */
public class UseFunctionService {

    FunctionService functionService;


    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String string){
        return functionService.sayHello(string);
    }
}

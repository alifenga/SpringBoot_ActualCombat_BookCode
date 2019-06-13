package xyz.alifenga.page22;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 此类也不使用@ComponentScan去扫描包,所有Bean在类中定义
 *
 * @Bean 声明当前方法的返回值是一个Bean, Bean的名称是方法名
 */
@Configuration
public class JavaConfig {

    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }

//    使用参数赋值注入
//    @Bean
//    public UseFunctionService useFunctionService(FunctionService functionService){
//        UseFunctionService useFunctionService = new UseFunctionService();
//        useFunctionService.setFunctionService(functionService);
//        return  useFunctionService;
//    }
}

package xyz.alifenga.page33;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 演示配置类
 */
@Configuration
@ComponentScan("xyz.alifenga.page33")
@PropertySource("classpath:test.properties")
public class ElConfig {

    //普通字符串注入
    @Value("I Love You")
    private String normal;

    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    //注入表达式结果
    @Value("#{T(java.lang.Math).random()*100.0}")
    private double randomNumber;

    //注入其他Bean属性
    @Value("#{demoService.another}")
    private String fromAnother;

    //注入文件资源
    @Value("classpath:test.txt")
    private Resource testFile;

    //注入网址资源
    @Value("https://www.baidu.com")
    private Resource testUrl;

    //注入配置文件
    @Value("${book.name}")
    private String bookName;

    //注入配置文件
    @Autowired
    private Environment environment;

    //注入配置文件 若使用@Value注入,则需要配置一个PropertySourcesPlaceholderConfigurer的Bean
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

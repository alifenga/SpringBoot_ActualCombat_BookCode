package xyz.alifenga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.alifenga.bean.AuthorSettings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
@Controller
public class SpringBootDemoApplication {

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "书名:" + bookName + "\t作者:" + bookAuthor + "\t" + authorSettings.getName() + "\t" + authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}

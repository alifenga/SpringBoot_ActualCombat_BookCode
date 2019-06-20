package xyz.alifenga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.alifenga.bean.Person;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }


    @RequestMapping("/")
    public String index(Model model){
        Person person = new Person("张三",11);

        List<Person> list = new ArrayList<>();
        list.add(new Person("李四",12));
        list.add(new Person("王五",13));
        list.add(new Person("赵六",14));
        model.addAttribute("singlePerson",person);
        model.addAttribute("people",list);
        return "index";
    }
}

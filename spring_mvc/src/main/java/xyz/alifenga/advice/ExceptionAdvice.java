package xyz.alifenga.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通过@ControllerAdvice,我们可以将对于控制的全局配置放置在同一个位置,
 * 注解了@Controller的类的方法可使用@ExceptionHandler,@InitBinder,@ModelAttribute注解到方法上
 * 这对所有注解了@RequestMapping的控制器内的方法有效
 * <p>
 * 注解:@ExceptionHandler:用于全局处理控制器的异常
 * 注解:@InitBinder:用来设置WebDataBinder,WebDataBinder用来自动绑定前台请求参数到model中
 * 注解:@ModerAttribute本来的作用是绑定键值对到Model里,此处是让全局的@RequestMapping都能获得在此处设置的键值对
 */
//声明一个控制器建言,@ControllerAdvice组合了@Component所以自动注册为Spring的Bean
@ControllerAdvice
public class ExceptionAdvice {

    /**
     * 在此处定义全局处理,通过@ExceptionHandler的value属性可过滤拦截的条件,此处拦截所有的Exception
     *
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /**
     * 此处使用@ModelAttribute注解将键值对添加到全局,所有注解@RequestMapping的方法可获得此键值对
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    /**
     * 使用@InitBinder定制WebDataBinder
     *
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}

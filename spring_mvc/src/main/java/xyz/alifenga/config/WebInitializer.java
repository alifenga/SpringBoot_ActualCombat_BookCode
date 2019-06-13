package xyz.alifenga.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * WEB配置
 * WebApplicationInitializer是Spring提供用来配置Servlet3.0+配置的接口,
 * 从而实现替代web.xml的位置,实现此接口将会自动被SpringServletConatainerInitializer获取的
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //将新建的配置类与servletContext关联
        context.register(MyMvcConfig2.class);
        context.setServletContext(servletContext);
        //注入SpringMVC的DispatchServlet
        Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}

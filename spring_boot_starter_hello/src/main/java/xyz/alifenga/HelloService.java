package xyz.alifenga;

/**
 * 判断依据类
 * 本例根据此类的存在与否来创建这个类的Bean
 */
public class HelloService {

    private String msg;

    public String sayHello() {
        return "Hello\t" + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

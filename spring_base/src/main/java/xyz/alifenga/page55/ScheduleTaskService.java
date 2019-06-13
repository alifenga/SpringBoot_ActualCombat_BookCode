package xyz.alifenga.page55;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计划任务执行类
 */
@Service
public class ScheduleTaskService {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 通过@Scheduled声明该方法是计划任务,使用fixedRate属性每隔固定的时间执行(毫秒)
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("reportCurrentTime每隔5秒执行一次:"+DATE_FORMAT.format(new Date()));
    }

    /**
     * 使用cron属性写表达式,这里是每5秒执行一次
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void fixTimeExecution(){
        System.out.println("fixTimeExecution每隔5秒执行一次:"+DATE_FORMAT.format(new Date()));
    }
}

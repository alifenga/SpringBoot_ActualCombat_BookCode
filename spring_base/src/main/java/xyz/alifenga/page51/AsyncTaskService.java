package xyz.alifenga.page51;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 任务执行类
 */

@Service
public class AsyncTaskService {

    /**
     * 通过@Async注解表明该方法是个异步方法
     * 如果注解在类级别,则表明该类所有的方法都是异步方法
     */
    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("executeAsyncTask执行异步类:" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("executeAsyncTaskPlus执行异步类:" + i);
    }
}

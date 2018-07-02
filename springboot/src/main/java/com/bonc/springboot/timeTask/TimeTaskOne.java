package com.bonc.springboot.timeTask;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author:liming
 * @Description: 定时任务
 * @Date:create in 2018/7/2   15:54
 */
@EnableScheduling  //开启定时任务注解，可以设置在启动类中，也可以设置在定时任务实体类中
@Component
public class TimeTaskOne {

    @Scheduled(cron = "0 0/1  * * * ?")  //项目启动每一分钟执行一次
    public void timeTaskJob(){
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Scheduled(fixedRate = 5000)  //项目启动后，每五秒执行一次
    public void timerToZZP(){
        System.out.println("ZZP:" + new Random().nextLong() + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    @Scheduled(fixedDelay = 50000)  //50秒后开始执行
    public void timerToReportCount(){
        for (int i = 0; i < 10; i++){
            System.out.println("<================its" + i + "count===============>" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

    @Scheduled(initialDelay = 50000,fixedRate = 6000)  //启动后50秒，每6秒执行一次
    public void timerToReport(){
        for (int i = 0; i < 10; i++){
            System.out.println("<================delay :" + i + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "count===============>");
        }
    }
}

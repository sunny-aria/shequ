package com.kd.shequ.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时任务
 *
 * @author sunny
 * @create 2018/6/28 18:24
 **/
@Component
public class ScheduleTask {

//    @Scheduled(fixedRate=5000)
    public void currentTime(){
        System.out.println("当前时间："+ LocalDateTime.now().toString());
    }
}

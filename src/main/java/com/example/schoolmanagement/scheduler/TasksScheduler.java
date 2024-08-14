package com.example.schoolmanagement.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksScheduler {
    int i = 0;

//    @Scheduled(cron = "* * * * * *")
//    public void scheduleTask() {
//        System.out.println(i++);
//    }
}

package com.example.schoolmanagement.scheduler;

import com.example.schoolmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TasksScheduler {
    private final TaskService taskService;

    //    @Scheduled(cron = "10 * * * * *")
    public void setDeadLineForTask() {
        log.info("ActionLog.setDeadLineForTask.start");
        taskService.setDeadlineForTask();
        log.info("ActionLog.setDeadLineForTask.end");
    }

    //    @Scheduled(cron = "10 32 * * * *")
    public void checkDeadlineForTask() {
        log.info("ActionLog.checkDeadlineForTask.start");
        taskService.checkDeadlineForTask();
        log.info("ActionLog.checkDeadlineForTask.end");
    }
}

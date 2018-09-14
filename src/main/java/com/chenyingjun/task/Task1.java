package com.chenyingjun.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Configurable
@EnableScheduling
public class Task1 {
    private static Log logger = LogFactory.getLog(Task1.class);

    @Scheduled(cron = "0/2 * * * * * ")
    public void execute() {
        logger.info("Task1>>" + new Date());
    }
}

package com.chenyingjun.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;

public class Task4 implements Runnable {

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private static Log logger = LogFactory.getLog(Task4.class);

    @Override
    public void run() {
        logger.info("Task4================" + new Date());
    }

    /**
     * 设置cron并启动
     * @param cronExp cron值
     */
    public void reStart(String cronExp) {
        if (null != this.threadPoolTaskScheduler) {
            ScheduledExecutorService scheduledExecutorService = this.threadPoolTaskScheduler.getScheduledExecutor();
            if (!scheduledExecutorService.isShutdown()) {
                scheduledExecutorService.shutdownNow();
            }

            this.threadPoolTaskScheduler.destroy();
        }

        if (null != cronExp && cronExp.trim().length() > 0) {
            this.threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
            this.threadPoolTaskScheduler.setThreadNamePrefix("task4");
            this.threadPoolTaskScheduler.initialize();
            this.threadPoolTaskScheduler.schedule(this, new CronTrigger(cronExp));
        }
    }
}

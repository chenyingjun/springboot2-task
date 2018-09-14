package com.chenyingjun.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class Task3 {

    @Resource(name = "jobTrigger")
    private CronTrigger cronTrigger;

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    private static Log logger = LogFactory.getLog(Task3.class);

    public void task() {
        logger.info("Task3---------" + new Date());
    }

    /**
     * 设置cron并重启定时器
     * @param cron cron值
     */
    public void setCron(String cron) {
        try {
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            // 按新的cronExpression表达式重新构建trigger
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
            trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
                    .withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
        } catch (SchedulerException e) {
            logger.info("cron表达式错误");
        }
    }
}

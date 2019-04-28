package com.jzl.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:01 2019/4/28
 * @Modified By:
 */
public class TestQuartz {
    @Test
    public void testCommonJob() throws SchedulerException {
        JobDetail jobdetail = JobBuilder
                .newJob(CommonJob.class)
                .withIdentity("job1", "group")
                .build();

        SimpleTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger", "group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(2).repeatForever())
                .build();
        //以下使用cron表达式方式
//        TriggerKey triggerKey = TriggerKey.triggerKey("trigger_name", "trigger_group");
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("10 */1 * * * ?");
//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();

        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobdetail,trigger);

    }
}

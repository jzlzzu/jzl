package com.jzl.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:01 2019/4/28
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQuartz {

    @Autowired
    private CommonJobService commonJobService;

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
        scheduler.scheduleJob(jobdetail, trigger);

    }

    @Test
    public void testCommonJobService() throws SchedulerException {
        commonJobService.addJob();
    }
}

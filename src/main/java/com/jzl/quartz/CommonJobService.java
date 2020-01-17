package com.jzl.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:59 2019/6/13
 * @Modified By:
 */
@Service
public class CommonJobService {

    @Autowired
    private Scheduler scheduler;

    public void addJob() throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("jobname", "jobgroup");

        // requestRecovery() : 当系统重启时会重新执行 qrtz_fired_triggers(记录正在运行的任务)中的任务
        JobDetail jobdetail = JobBuilder.newJob(CommonJob.class).withIdentity(jobKey).requestRecovery().build();
        jobdetail.getJobDataMap().put("jzl", "jzl");


        TriggerKey triggerKey = TriggerKey.triggerKey("triggerName", "triggerGroup");
        /**
         * withMisfireHandlingInstructionDoNothing : 所有misfire的任务不管,执行下一个周期的任务,但是下一个周期的执行时间已过的话,任务不会再次执行
         * withMisfireHandlingInstructionFireAndProceed : 会合并部分的misfire 正常执行下一个周期的任务
         * withMisfireHandlingInstructionIgnoreMisfires : 所有的misfire的任务会马上执行
         */
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(" */10 * * * * ?").withMisfireHandlingInstructionDoNothing();
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(" */10 * * * * ?").withMisfireHandlingInstructionFireAndProceed();
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(" */10 * * * * ?").withMisfireHandlingInstructionIgnoreMisfires();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        scheduler.start();
        scheduler.scheduleJob(jobdetail, cronTrigger);

    }


}

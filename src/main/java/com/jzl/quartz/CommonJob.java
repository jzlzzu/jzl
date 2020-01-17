package com.jzl.quartz;

import org.quartz.*;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:23 2019/4/23
 * @Modified By:
 * @DisallowConcurrentExecution : 禁止任务并行,将单个任务变成串行
 * @PersistJobDataAfterExecution : 持久化jobDataMap数据到库表
 */
@Component
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class CommonJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        jobDataMap.put("jzl", "123");
    }
}

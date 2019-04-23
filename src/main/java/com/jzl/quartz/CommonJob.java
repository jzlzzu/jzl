package com.jzl.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:23 2019/4/23
 * @Modified By:
 */
public class CommonJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("ceshi");
    }
}

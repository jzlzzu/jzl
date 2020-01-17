package com.jzl.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:53 2019/6/13
 * @Modified By:
 */
@Component
public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        return null;
    }

    /**
     * 任务执行前调用
     *
     * @param jobExecutionContext
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

    }

    /**
     * 任务执行后调用
     *
     * @param jobExecutionContext
     * @param e
     */
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {

    }
}

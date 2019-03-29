package com.hallth.utils;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SpringQtz extends QuartzJobBean{
    private static int counter = 0;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println();
        long ms = System.currentTimeMillis();
        System.out.println("============= Message from SpringQuartz =============\n(" + counter++ + ")");
        System.out.println(ms);
    }

}

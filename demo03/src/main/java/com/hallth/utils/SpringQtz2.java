package com.hallth.utils;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class SpringQtz2 {
    private static int counter = 0;
    public void doSomething() {
        System.err.println("****:" + System.currentTimeMillis());
    }

}


package com.hallth.utils;


import org.springframework.stereotype.Service;

@Service
public class SpringQtz2 {
    private static int counter = 0;
    public void doSomething() {
        System.err.println("============= Message from SpringQuartz2 =============\n" + System.currentTimeMillis());
    }

}


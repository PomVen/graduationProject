package com.hallth.service.impl;

import com.hallth.domain.Dengmi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class DengmiServiceImplTest {

    @Autowired
    private DengmiServiceImpl dengmiService;

    @Test
    public void selectDengmiByPage() {
        Dengmi dengmi = new Dengmi();
        dengmi.setMidi("高考");
        List<Dengmi> dengmis = dengmiService.selectDengmiByPage(dengmi);
        System.out.println("Message from test ; " + dengmis.size());
    }

    @Test
    public void getDengmiCount() {
        Dengmi dengmi = new Dengmi();
        dengmi.setMidi("高考");
        long dengmis = dengmiService.getDengmiCount(dengmi);
        System.out.println("Message from test : " + dengmis);
    }
}
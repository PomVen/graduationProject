package com.hallth.mapper;

import com.hallth.domain.Dengmi;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class DengmiMapperTest {

    private ApplicationContext applicationContext;
    @Resource
    private DengmiMapper mapper;

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() {
        Dengmi dengmi = mapper.selectByPrimaryKey(1);
        System.out.println(dengmi.toString());
    }

    @Test
    public void selectDengmiByPage() {
        Dengmi dengmi = new Dengmi();
        dengmi.setMimian("目前");
        List<Dengmi> dengmis = mapper.selectDengmiByPage(dengmi);
        System.out.println(dengmis.size());

    }

    @Test
    public void getDengmiCount() {
        Dengmi dengmi = new Dengmi();
        dengmi.setMidi("高考");
        long dengmis = mapper.getDengmiCount(dengmi);
        System.out.println(dengmis);
    }

    @Test
    public void findByPage() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("start", 123);
        map.put("size",10);
        List<Dengmi> dengmiList = mapper.findByPage(map);
        for(Dengmi d : dengmiList){
            System.out.println(d.toString());
        }
    }
}
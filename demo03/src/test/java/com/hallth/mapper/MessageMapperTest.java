package com.hallth.mapper;

import com.hallth.domain.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MessageMapperTest {

    private ApplicationContext applicationContext;

    @Autowired
    private MessageMapper mapper;

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        Message message = new Message();
        message.setId(2);
        message.setDescription("这是描述");
        message.setContent("这是内容");
        message.setCommand("Command");
        int a = mapper.insert(message);
        System.out.println("Insert Finished: [" + a + "]");
    }

    @Test
    public void selectByPrimaryKey() {
        Message message = mapper.selectByPrimaryKey(2);
        System.out.println("Select Finished: message=" + message.toString());
    }
}
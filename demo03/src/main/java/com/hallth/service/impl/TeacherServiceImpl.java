package com.hallth.service.impl;

import com.hallth.domain.Teacher;
import com.hallth.mapper.TeacherMapper;
import com.hallth.service.TeacherService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher selectByName(String teacherName){
        Teacher queryParam = new Teacher();
        queryParam.setteacherName(teacherName);
        queryParam.setteacherPhone("18734914196");
        queryParam.setteacherAddress("山西");
        queryParam.setteacherAge(45);
        queryParam.setteacherEmail("123@5.com");
        queryParam.setteacherGender("男");
        queryParam.setteacherId("huoyangshuai");
        queryParam.setteacherMajor("灯谜");
        queryParam.setteacherSeq(1);
        return queryParam;//teacherMapper.selectByName(queryParam);
    }

    @Override
    public Teacher selectBySeq(int teacherSeq){
        Teacher queryParam = new Teacher();
        queryParam.setteacherName("霍仰帅");
        queryParam.setteacherPhone("18734914196");
        queryParam.setteacherAddress("山西");
        queryParam.setteacherAge(45);
        queryParam.setteacherEmail("123@5.com");
        queryParam.setteacherGender("男");
        queryParam.setteacherId("huoyangshuai");
        queryParam.setteacherMajor("灯谜");
        queryParam.setteacherSeq(teacherSeq);
        return queryParam;//teacherMapper.selectBySeq(queryParam);
    }

}

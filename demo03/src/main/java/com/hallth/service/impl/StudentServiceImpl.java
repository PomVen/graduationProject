package com.hallth.service.impl;

import com.hallth.domain.Student;
import com.hallth.mapper.StudentMapper;
import com.hallth.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    private static Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());

    @Resource
    private StudentMapper studentMapper;

    public Student userCheck(Student student){
        logger.info("校验用户密码是否正确，若正确会返回用户对象，否则返回null；param：【"+student.toString()+"】");
        Student result = studentMapper.userLoginCheck(student);
        return  result;
    }
}

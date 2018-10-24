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

    public int insert(Student record){
        logger.info("新建用户；param：【"+record.toString()+"】");
        int result = studentMapper.insert(record);
        return result;
    }

    public int updateStudent(Student student){
        logger.info("更新用户信息；param:["+ student.toString() +"]");
        int result = studentMapper.updateByPrimaryKeySelective(student);
        return result;
    }

    public Student quetyByUserName(Student student){
        logger.info("查询当前登录的学生信息;param="+student.toString());
//        student = studentMapper.selectByStudentName(student);
        //测试数据
        student.setTheme("毕业设计选择课题系统");
        return student;
    }

    public boolean updateByStudentName(Student student){
        int a  = 1;//studentMapper.updateByStudentName(student);
        return a > 0 ? true : false;
    }

}

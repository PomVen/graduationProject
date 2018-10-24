package com.hallth.mapper;

import com.hallth.domain.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuSeq);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuSeq);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student userLoginCheck(Student student);

    Student selectByStudentName(Student student);

    int updateByStudentName(Student student);
}
package com.hallth.service;

import com.hallth.domain.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher selectByName(String teacherName);

    Teacher selectBySeq(int teacherName);

    Teacher userCheck(Teacher teacher);

    List<Integer> selectByNameFuzzyQuery(String teacherName);
}

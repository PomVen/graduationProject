package com.hallth.mapper;

import com.hallth.domain.Teacher;

import java.util.List;

public interface TeacherMapper {

    Teacher selectByName(Teacher param);

    Teacher selectBySeq(Teacher teacher);

    Teacher userCheck(Teacher teacher);

    List<Integer> selectByNameFuzzyQuery(Teacher teacher);

}

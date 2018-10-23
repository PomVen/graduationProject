package com.hallth.mapper;

import com.hallth.domain.Teacher;

public interface TeacherMapper {

    Teacher selectByName(Teacher param);

    Teacher selectBySeq(Teacher teacher);

}

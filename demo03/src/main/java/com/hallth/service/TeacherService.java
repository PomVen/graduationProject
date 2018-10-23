package com.hallth.service;

import com.hallth.domain.Teacher;

public interface TeacherService {

    Teacher selectByName(String teacherName);
}

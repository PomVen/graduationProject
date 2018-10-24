package com.hallth.mapper;

import com.hallth.domain.GraduationTheme;

import java.util.List;

public interface GraduationThemeMapper {
    List<GraduationTheme> query(GraduationTheme graduationTheme);

    GraduationTheme queryBySeq(GraduationTheme graduationTheme);

    GraduationTheme queryByTitle(GraduationTheme graduationTheme);

    List<GraduationTheme> selectByTeacherAndTitle(GraduationTheme graduationTheme);
}

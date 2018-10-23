package com.hallth.service;

import com.hallth.domain.GraduationTheme;
import com.hallth.domain.PageBean;

import java.util.List;

public interface GraduationThemeService {

    PageBean<GraduationTheme>  queryTheme(GraduationTheme graduationTheme);

}

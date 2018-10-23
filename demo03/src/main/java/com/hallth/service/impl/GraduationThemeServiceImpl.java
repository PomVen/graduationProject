package com.hallth.service.impl;

import com.hallth.domain.GraduationTheme;
import com.hallth.domain.PageBean;
import com.hallth.mapper.GraduationThemeMapper;
import com.hallth.service.GraduationThemeService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class GraduationThemeServiceImpl implements GraduationThemeService {

    @Resource
    private GraduationThemeMapper graduationThemeMapper;


    @Override
    public PageBean<GraduationTheme> queryTheme(GraduationTheme graduationTheme) {
        List<GraduationTheme> res = new ArrayList<GraduationTheme>();//graduationThemeMapper.query(graduationTheme);

        //测试用数据
        GraduationTheme theme = new GraduationTheme();
        theme.setthemeTitle("毕业设计选课系统");
        theme.setthemeIntroduction("毕业生毕业设计的选题系统，也可以展示相关信息，并显示当前的进度");
        theme.setthemeSeq(1);
        theme.setthemeTeacher(1);
        res.add(theme);
        PageBean<GraduationTheme> result =new PageBean<GraduationTheme>();
        result.setCurrPage(1);
        result.setPageSize(10);
        result.setTotalPage(res.size()%10 == 0 ? res.size()/10 : (res.size()/10 + 1));
        result.setTotalCount(res.size());
        result.setLists(res);
        return result;
    }
}

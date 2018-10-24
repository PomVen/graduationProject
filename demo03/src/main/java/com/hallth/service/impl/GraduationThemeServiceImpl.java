package com.hallth.service.impl;

import com.hallth.domain.GraduationTheme;
import com.hallth.domain.PageBean;
import com.hallth.domain.Teacher;
import com.hallth.mapper.GraduationThemeMapper;
import com.hallth.mapper.TeacherMapper;
import com.hallth.service.GraduationThemeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GraduationThemeServiceImpl implements GraduationThemeService {

    @Resource
    private GraduationThemeMapper graduationThemeMapper;

    @Resource
    private TeacherMapper teacherMapper;


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

    public Teacher getTeacherByTheme(GraduationTheme theme){
//        theme = graduationThemeMapper.queryBySeq(theme);
        //测试数据
        theme.setthemeTeacher(1);
        int teacherSeq = theme.getthemeTeacher();
        Teacher teacher = new Teacher();
        teacher.setteacherSeq(teacherSeq);
//        teacher = teacherMapper.selectBySeq(teacher);
        //测试数据
        teacher.setteacherMajor("灯谜");
        teacher.setteacherId("huoyangshuai");
        teacher.setteacherGender("男");
        teacher.setteacherEmail("123@123.com");
        teacher.setteacherAddress("山西");
        teacher.setteacherPhone("123465");
        teacher.setteacherAge(35);
        teacher.setteacherName("霍仰帅");
        return teacher;
    }

    public GraduationTheme queryThemeByTitle(GraduationTheme theme){
//        theme = graduationThemeMapper.queryByTitle(theme);?
        //测试数据
        theme.setthemeTitle("毕设课题选择");
        theme.setthemeTeacher(1);
        theme.setthemeIntroduction("学生选择毕设题目，并跟进进度");
        theme.setthemeSeq(1);
        return theme;
    }

    public PageBean<GraduationTheme> selectByTeacherAndTitle(GraduationTheme theme){
        List<GraduationTheme> queryList = new ArrayList<>();//graduationThemeMapper.selectByTeacherAndTitle(theme);
        //测试用数据
        GraduationTheme theme1 = new GraduationTheme();
        theme1.setthemeTitle("毕设课题选择");
        theme1.setTeacherName("张三");
        theme1.setthemeIntroduction("学生选择毕设题目，并跟进进度");
        theme1.setthemeSeq(1);
        queryList.add(theme1);

        GraduationTheme theme2 = new GraduationTheme();
        theme2.setthemeTitle("淘宝在线商城");
        theme2.setTeacherName("李四");
        theme2.setthemeIntroduction("模拟电子商务网站");
        theme2.setthemeSeq(2);
        queryList.add(theme2);

        GraduationTheme theme3 = new GraduationTheme();
        theme3.setthemeTitle("聊天软件");
        theme3.setTeacherName("王五");
        theme3.setthemeIntroduction("模拟QQ");
        theme3.setthemeSeq(3);
        queryList.add(theme3);

        PageBean pageBean = new PageBean();
        pageBean.setLists(queryList);
        pageBean.setTotalCount(queryList.size());
        return pageBean;
    }

    @Override
    public PageBean<GraduationTheme> getGraduationTheme(GraduationTheme searchModel, int pageNum, int pageSize) {
        return null;
    }
}

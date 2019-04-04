package com.hallth.controller;

import com.hallth.domain.GraduationTheme;
import com.hallth.domain.Student;
import com.hallth.domain.UserLoginInfo;
import com.hallth.service.GraduationThemeService;
import com.hallth.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private StudentService studentService;
    @Resource
    private GraduationThemeService graduationThemeService;

    @RequestMapping("/themeProgress")
    public String themeProgress(){
        return "teacher/themeProgress";
    }

    @RequestMapping("/teacherIntroduce")
    public String teacherIntroduce(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute("loginUserInfo");
        String userName = userLoginInfo.getLoginUserName();
        Student student = new Student();
        student.setStuName(userName);
        student = studentService.quetyByUserName(student);
        String theme = student.getTheme();
//        Teacher teacher = null;
//        if(theme == null || theme.isEmpty()){
//            model.addAttribute("teacherInfo",teacher);
//        } else {
//            GraduationTheme graduationTheme = new GraduationTheme();
//            graduationTheme.setthemeTitle(theme);
//            teacher = graduationThemeService.getTeacherByTheme(graduationTheme);
//            model.addAttribute("teacherInfo",teacher);
//        }
        return "teacher/teacherIntroduce";
    }

    @RequestMapping("/themeDescription")
    public String themeDescription(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute("loginUserInfo");
        String userName = userLoginInfo.getLoginUserName();
        Student student = new Student();
        student.setStuName(userName);
        student = studentService.quetyByUserName(student);
        String theme = student.getTheme();
        if(null == theme || "".equals(theme)){
            model.addAttribute("theme",null);
        } else {
            GraduationTheme graduationTheme = new GraduationTheme();
            graduationTheme.setthemeTitle(theme);
            graduationTheme = graduationThemeService.queryThemeByTitle(graduationTheme);
//            graduationTheme.setTeacherName(teacherService.selectBySeq(graduationTheme.getthemeTeacher()).getteacherName());
            model.addAttribute("theme",graduationTheme);
        }
        return "teacher/themeDescription";
    }
}
